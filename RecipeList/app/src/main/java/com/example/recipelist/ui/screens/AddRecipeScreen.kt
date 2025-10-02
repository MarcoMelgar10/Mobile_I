package com.example.recipelist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipelist.ui.objects.Recipe
import com.example.recipelist.ui.theme.RecipeListTheme
import com.example.recipelist.ui.viewModels.RecipeLogic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecipeScreen(modifier: Modifier = Modifier, navController: NavController ,vm: RecipeLogic) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val ingredients = vm.dataIngredients()
    var selectedIngredients by remember { mutableStateOf<Set<String>>(emptySet()) }
    var recipe = Recipe("", "", listOf(""))
    var showDialog by remember { mutableStateOf(false) }
    var isFormValid = name.isNotBlank() && description.isNotBlank() && selectedIngredients.isNotEmpty()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Recipe") }
            )
        },
        bottomBar = {
            Button(
                onClick = {
                    recipe = Recipe(name, description, selectedIngredients.toList())
                    vm.addRecipe(recipe)
                    showDialog = true
                },
                enabled = isFormValid,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
            ) {
                Text("Save Recipe")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Recipe Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
                    .height(120.dp),
                maxLines = 8
            )

            Text("Select Ingredients:", style = MaterialTheme.typography.titleMedium)

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(ingredients) { ingredient ->
                    val isSelected = selectedIngredients.contains(ingredient)
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            selectedIngredients = if (isSelected) {
                                selectedIngredients - ingredient
                            } else {
                                selectedIngredients + ingredient
                            }
                        },
                        label = { Text(ingredient) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
    if (showDialog) {
        vm.SimpleMessageDialog(showDialog = showDialog, navController,onDismiss = { showDialog = false })
    }

}



@Preview(showBackground = true)
@Composable
fun AddRecipeScreenPreview() {
    RecipeListTheme {
      //  AddRecipeScreen(navController = rememberNavController(), vm = RecipeLogic())
    }
}
