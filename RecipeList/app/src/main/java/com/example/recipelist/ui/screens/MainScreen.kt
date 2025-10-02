package com.example.recipelist.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.recipelist.ui.theme.RecipeListTheme
import com.example.recipelist.ui.viewModels.RecipeLogic
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    vm: RecipeLogic
) {
    val ingredients = vm.dataIngredients()
    var selectedIngredients by remember { mutableStateOf<Set<String>>(emptySet()) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    val results = vm.findRecipeByIngredient(selectedIngredients.toList())
                    if (results.isNotEmpty()) {
                        navController.navigate("RECIPESCREEN")
                    } else {
                        showDialog = true
                    } },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Search Recipes")
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("No recipes found") },
                    text = { Text("Do you want to:\n\n - Try again?\n - Add a new recipe?") },
                    confirmButton = {
                        TextButton(onClick = {
                            showDialog = false
                            navController.navigate("ADDRECIPESCREEN")
                        }) {
                            Text("Add Recipe")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialog = false
                        }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                "                     Ingredients",
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier
                    .padding(16.dp)
            )

            ingredients.forEach { ingredient ->
                val isSelected = selectedIngredients.contains(ingredient)

                val buttonColors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color.Black else MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )

                Button(
                    onClick = {
                        selectedIngredients = if (isSelected) {
                            selectedIngredients - ingredient
                        } else {
                            selectedIngredients + ingredient
                        }
                              },
                    colors = buttonColors,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                     .fillMaxWidth()
                ) {
                    Text(ingredient)
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RecipeListTheme {
      //  MainScreen(vm = RecipeLogic = viewModel())
    }
}