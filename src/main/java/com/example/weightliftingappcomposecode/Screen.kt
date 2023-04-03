package com.example.weightliftingappcomposecode

sealed class Screen(val route: String){
    object DashboardScreen : Screen("dashboard_screen")
    object AddPassScreen: Screen("addpass_screen")
}