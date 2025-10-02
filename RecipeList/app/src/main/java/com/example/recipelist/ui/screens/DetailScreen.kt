package com.example.recipelist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recipelist.ui.viewModels.RecipeLogic

@Composable
fun DetailScreen(modifier: Modifier, vm : RecipeLogic) {
    val recipe = vm.dataRecipeContemporany()
    val scrollState = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = "Detail Screen",
            modifier = Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .padding(horizontal = 18.dp)
        )
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .padding(vertical = 20.dp)
                .fillMaxSize()
            .verticalScroll(scrollState)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (recipe != null) {
                Text("Recipe:")
                Text(recipe.name)
                Text("Description:")
                Text(recipe.description)
                Text("Ingredients:")
                for (ingredient in recipe.ingredients) {
                 Text(ingredient, modifier = Modifier
                     .fillMaxWidth()
                     .padding(vertical = 5.dp))
                }
            }
        }


    }
}
