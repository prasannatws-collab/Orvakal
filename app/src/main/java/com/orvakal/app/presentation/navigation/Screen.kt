package com.orvakal.app.presentation.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Home : Screen("home")
    data object InfoHub : Screen("infohub")
    data object FarmerDesk : Screen("farmerdesk")
    data object Services : Screen("services")
    data object Jobs : Screen("jobs")
    data object Detail : Screen("detail/{categoryKey}") {
        fun createRoute(categoryKey: String) = "detail/$categoryKey"
        fun createRoute(serviceId: Int) = "detail/$serviceId"
    }
    data object Utilities : Screen("utilities/{initialTab}") {
        fun createRoute(initialTab: Int = 0) = "utilities/$initialTab"
    }
    data object IndustrialHubInsights : Screen("industrial_hub_insights")
    data object MandalProfile : Screen("mandal_profile")
    data object Profile : Screen("profile")
}
