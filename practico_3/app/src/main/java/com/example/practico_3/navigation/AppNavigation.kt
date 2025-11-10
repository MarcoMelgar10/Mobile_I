package com.example.practico_3.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practico_3.ui.screens.*
import com.example.practico_3.ui.viewmodel.SplashViewModel
import com.example.practico_3.ui.viewmodel.TripViewModel

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object AllTrips : Screen("all_trips")
    object MyTrips : Screen("my_trips")
    object TripDetail : Screen("trip_detail/{tripId}/{tripName}") {
        fun createRoute(tripId: Int, tripName: String) = "trip_detail/$tripId/$tripName"
    }
    object PlaceDetail : Screen("place_detail")
    object CreateTrip : Screen("create_trip")
    object CreatePlace : Screen("create_place/{tripId}") {
        fun createRoute(tripId: Int) = "create_place/$tripId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val splashViewModel: SplashViewModel = viewModel()
    val tripViewModel: TripViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(
                viewModel = splashViewModel,
                onNavigateToAllTrips = { username ->
                    tripViewModel.setCurrentUsername(username)
                    navController.navigate(Screen.AllTrips.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.AllTrips.route) {
            AllTripsScreen(
                viewModel = tripViewModel,
                onNavigateToMyTrips = {
                    navController.navigate(Screen.MyTrips.route)
                },
                onNavigateToCreateTrip = {
                    navController.navigate(Screen.CreateTrip.route)
                },
                onTripClick = { trip ->
                    navController.navigate(Screen.TripDetail.createRoute(trip.id ?: 0, trip.name))
                }
            )
        }

        composable(Screen.MyTrips.route) {
            MyTripsScreen(
                viewModel = tripViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToCreateTrip = {
                    navController.navigate(Screen.CreateTrip.route)
                },
                onTripClick = { trip ->
                    navController.navigate(Screen.TripDetail.createRoute(trip.id ?: 0, trip.name))
                }
            )
        }

        composable(
            route = Screen.TripDetail.route,
            arguments = listOf(
                navArgument("tripId") { type = NavType.IntType },
                navArgument("tripName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val tripId = backStackEntry.arguments?.getInt("tripId") ?: 0
            val tripName = backStackEntry.arguments?.getString("tripName") ?: ""
            TripDetailScreen(
                viewModel = tripViewModel,
                tripId = tripId,
                tripName = tripName,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToAddPlace = {
                    navController.navigate(Screen.CreatePlace.createRoute(tripId))
                },
                onPlaceClick = { place ->
                    tripViewModel.selectPlace(place)
                    navController.navigate(Screen.PlaceDetail.route)
                }
            )
        }

        composable(Screen.PlaceDetail.route) {
            PlaceDetailScreen(
                viewModel = tripViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.CreateTrip.route) {
            CreateTripScreen(
                viewModel = tripViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.CreatePlace.route,
            arguments = listOf(
                navArgument("tripId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val tripId = backStackEntry.arguments?.getInt("tripId") ?: 0
            CreatePlaceScreen(
                viewModel = tripViewModel,
                tripId = tripId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
