package com.example.multimodule.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object PrayerList : Screen(
        route = "prayerList",
        emptyList()
    )

    object PrayerDetail : Screen(
        route = "prayerDetail",
        arguments = emptyList()
        /*arguments = listOf(
            navArgument("prayerId") {
                type = NavType.StringType
            }
        )*/
    )
}
