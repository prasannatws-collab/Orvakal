package com.orvakal.app.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.orvakal.app.presentation.detail.DetailScreen
import com.orvakal.app.presentation.farmer.FarmerDeskScreen
import com.orvakal.app.presentation.govt.GovtInfoScreen
import com.orvakal.app.presentation.home.HomeScreen
import com.orvakal.app.presentation.insights.IndustrialHubInsightsScreen
import com.orvakal.app.presentation.jobs.JobsScreen
import com.orvakal.app.presentation.mandal.OrvakalMandalProfileScreen
import com.orvakal.app.presentation.profile.ProfileScreen
import com.orvakal.app.presentation.services.ServicesScreen
import com.orvakal.app.presentation.splash.SplashScreen
import com.orvakal.app.presentation.utilities.UtilitiesScreen

@Composable
fun OrvikalNavGraph() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Show Top Header on all screens except Splash
    val showTopBar = currentRoute != Screen.Splash.route

    // Show Bottom Bar on all 5 main screens from the screenshots
    val showBottomBar = currentRoute in listOf(
        Screen.Home.route,
        Screen.InfoHub.route,
        Screen.FarmerDesk.route,
        Screen.Services.route,
        Screen.Jobs.route
    )

    Scaffold(
        topBar = {
            if (showTopBar) {
                com.orvakal.app.presentation.common.OrvakalTopHeader(
                    onLogoClick = {
                        navController.navigate(Screen.MandalProfile.route)
                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(
                    onSplashComplete = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Splash.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToCategory = { categoryKey ->
                        navController.navigate(Screen.Detail.createRoute(categoryKey))
                    },
                    onNavigateToJobs = {
                        navController.navigate(Screen.Jobs.route)
                    },
                    onNavigateToFarmer = {
                        navController.navigate(Screen.FarmerDesk.route)
                    },
                    onNavigateToGovt = {
                        navController.navigate(Screen.InfoHub.route)
                    },
                    onNavigateToIndustrialHub = {
                        navController.navigate(Screen.IndustrialHubInsights.route)
                    },
                    onNavigateToUtilities = { tabIndex ->
                        navController.navigate(Screen.Utilities.createRoute(tabIndex))
                    },
                    onNavigateToMandalProfile = {
                        navController.navigate(Screen.MandalProfile.route)
                    }
                )
            }

            composable(Screen.InfoHub.route) {
                GovtInfoScreen(
                    onNavigateToCategory = { categoryKey ->
                        navController.navigate(Screen.Detail.createRoute(categoryKey))
                    },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.FarmerDesk.route) {
                FarmerDeskScreen(
                    onNavigateToCategory = { categoryKey ->
                        navController.navigate(Screen.Detail.createRoute(categoryKey))
                    },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.Services.route) {
                ServicesScreen(
                    onNavigateToCategory = { categoryKey ->
                        navController.navigate(Screen.Detail.createRoute(categoryKey))
                    },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.Jobs.route) {
                JobsScreen(
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    },
                    onViewIndustryDetails = { industry ->
                        navController.navigate(Screen.IndustrialHubInsights.route)
                    }
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("categoryKey") {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) { backStackEntry ->
                val categoryKey = backStackEntry.arguments?.getString("categoryKey") ?: ""
                DetailScreen(
                    categoryKey = categoryKey,
                    onBack = { navController.popBackStack() },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(
                route = Screen.Utilities.route,
                arguments = listOf(
                    navArgument("initialTab") {
                        type = NavType.IntType
                        defaultValue = 0
                    }
                )
            ) { backStackEntry ->
                val initialTab = backStackEntry.arguments?.getInt("initialTab") ?: 0
                UtilitiesScreen(
                    initialTab = initialTab,
                    onBack = { navController.popBackStack() },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.IndustrialHubInsights.route) {
                IndustrialHubInsightsScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.MandalProfile.route) {
                OrvakalMandalProfileScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}
