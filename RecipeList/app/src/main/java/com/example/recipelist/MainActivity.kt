package com.example.recipelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipelist.ui.screens.AddRecipeScreen
import com.example.recipelist.ui.screens.DetailScreen
import com.example.recipelist.ui.screens.MainScreen
import com.example.recipelist.ui.screens.NavScreens
import com.example.recipelist.ui.screens.RecipeScreen
import com.example.recipelist.ui.theme.RecipeListTheme
import com.example.recipelist.ui.viewModels.RecipeLogic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeListTheme {
                NavigationApp()
            }
       }
    }
}
@Composable
fun NavigationApp(navController: NavHostController = rememberNavController()) {
    val vm: RecipeLogic = viewModel()
    NavHost(
        navController = navController,
        startDestination = NavScreens.MAINSCREEN.name
    ) {
        composable(NavScreens.MAINSCREEN.name) {
            MainScreen(modifier = Modifier, navController, vm)
        }
        composable(NavScreens.DETAILSCREEN.name) {
            DetailScreen(modifier = Modifier, vm)
        }
        composable(NavScreens.RECIPESCREEN.name) {
            RecipeScreen(modifier = Modifier, navController, vm)
        }
        composable(NavScreens.ADDRECIPESCREEN.name){
            AddRecipeScreen(modifier = Modifier, navController = navController, vm)
        }

    }
}