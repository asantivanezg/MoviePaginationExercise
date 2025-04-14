package com.asantivanezg.paginationexercise.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asantivanezg.paginationexercise.ui.screen.home.HomeScreen
import com.asantivanezg.paginationexercise.ui.screen.login.LoginScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RoutingNames.LoginScreen
    ) {
        composable<RoutingNames.LoginScreen> {
            LoginScreen(navController)
        }
        composable<RoutingNames.HomeScreen> {
            HomeScreen()
        }
    }
}