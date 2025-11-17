package com.tuapp.MakerRouter.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tuapp.MakerRouter.presentation.screens.login.LoginScreen
import com.tuapp.MakerRouter.presentation.screens.route_list.RouteListScreen
import com.tuapp.MakerRouter.presentation.screens.route_map.RouteMapScreen

sealed class AppScreen(val route: String) {

    object Login : AppScreen("login")

    data object RouteList : AppScreen("route_list/{username}") {
        const val ARG_USERNAME = "username"
        fun createRoute(username: String) = "route_list/$username"
        val arguments = listOf(
            navArgument(ARG_USERNAME) { type = NavType.StringType }
        )
    }

    data object RouteMap : AppScreen("route_map/{username}/{routeId}/{routeName}") {
        const val ARG_USERNAME = "username"
        const val ARG_ROUTE_ID = "routeId"
        const val ARG_ROUTE_NAME = "routeName"
        fun createRoute(username: String, routeId: String, routeName: String) =
            "route_map/$username/$routeId/$routeName"
        val arguments = listOf(
            navArgument(ARG_USERNAME) { type = NavType.StringType },
            navArgument(ARG_ROUTE_ID) { type = NavType.StringType },
            navArgument(ARG_ROUTE_NAME) { type = NavType.StringType }
        )
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(
                onLoginSuccess = { username ->
                    navController.navigate(AppScreen.RouteList.createRoute(username))
                }
            )
        }

        composable(
            route = AppScreen.RouteList.route,
            arguments = AppScreen.RouteList.arguments
        ) { navBackStackEntry ->
            val username = navBackStackEntry.arguments?.getString(AppScreen.RouteList.ARG_USERNAME) ?: ""
            RouteListScreen(
                username = username,
                onRouteClick = { routeId, routeName ->
                    navController.navigate(AppScreen.RouteMap.createRoute(username, routeId, routeName))
                }
            )
        }

        composable(
            route = AppScreen.RouteMap.route,
            arguments = AppScreen.RouteMap.arguments
        ) { navBackStackEntry ->
            val username = navBackStackEntry.arguments?.getString(AppScreen.RouteMap.ARG_USERNAME) ?: ""
            val routeId = navBackStackEntry.arguments?.getString(AppScreen.RouteMap.ARG_ROUTE_ID) ?: ""
            val routeName = navBackStackEntry.arguments?.getString(AppScreen.RouteMap.ARG_ROUTE_NAME) ?: ""
            RouteMapScreen(
                username = username,
                routeId = routeId,
                routeName = routeName,
                onSaveComplete = { navController.popBackStack() }
            )
        }
    }
}