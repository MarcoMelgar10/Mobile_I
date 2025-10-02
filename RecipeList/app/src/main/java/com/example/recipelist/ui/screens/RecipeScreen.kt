package com.example.recipelist.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.recipelist.ui.viewModels.RecipeLogic


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(modifier: Modifier = Modifier, navController: NavController, vm: RecipeLogic) {
    val recipes = vm.dataRecipesFilter()
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Recipes") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(recipes.size) { index ->
                val recipe = recipes[index]
                val isSelected = selectedIndex == index
                Text(
                    text = recipe.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                                vm.contemporanyRecipe(recipe)
                                navController.navigate("DETAILSCREEN")
                        }
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primaryContainer
                            else Color.Transparent
                        )
                        .padding(16.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}