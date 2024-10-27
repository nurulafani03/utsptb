package com.lixoten.demonavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.Start.name,
        modifier = modifier
    ) {
        composable(route = AppDestinations.Start.name) {
            ScreenStart(
                onNextButtonClicked = {
                    navController.navigate(AppDestinations.ScreenTwo.name)
                }
            )
        }
        composable(route = AppDestinations.ScreenTwo.name) {
            ScreenTwo(
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(navController)
                },
                onNextButtonClicked = {
                    navController.navigate(AppDestinations.ScreenThree.name)
                }
            )
        }
        composable(route = AppDestinations.ScreenThree.name) {
            ScreenThree(
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(navController)
                },
                onNextButtonClicked = {
                    navController.navigate(AppDestinations.ScreenFour.name)
                }
            )
        }
        composable(route = AppDestinations.ScreenFour.name) {
            ScreenFour(
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(navController)
                },
                onNextButtonClicked = { buyerName, buyerEmail ->
                    // Navigasi ke ScreenLast tanpa membawa parameter
                    navController.navigate(AppDestinations.Last.name)
                }
            )
        }
        composable(route = AppDestinations.Last.name) {
            ScreenLast(
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(navController)
                }
            )
        }
    }
}

fun cancelAndNavigateToStart(
    navController: NavHostController
) {
    navController.popBackStack(
        AppDestinations.Start.name,
        inclusive = false
    )
}
