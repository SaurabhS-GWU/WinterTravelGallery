package com.example.wintertravelgallery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.wintertravelgallery.ui.DestinationsScreen.DestinationsScreen as DestinationsListScreen
import com.example.wintertravelgallery.ui.Screen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Screen.DestinationsScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.DestinationsScreen> {
                DestinationsListScreen()
            }
        }
    )
}