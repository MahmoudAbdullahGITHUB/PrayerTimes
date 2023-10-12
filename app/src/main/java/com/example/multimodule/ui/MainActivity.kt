package com.example.multimodule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.core.domain.ProgressBarState
import com.example.multimodule.ui.navigation.Screen
import com.example.multimodule.ui.theme.MultiModuleTheme
import com.example.ui_prayerDetail.PrayerDetailScreen
import com.example.ui_prayerList.ui.PrayerTimeViewModel
import com.example.ui_prayerList.ui.PrayerTimesHome
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val progressBarState: MutableState<ProgressBarState> =
        mutableStateOf(ProgressBarState.Idle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MultiModuleTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "prayerList",
                    builder = {
                        composable(
                            route = Screen.PrayerList.route
                        ) { it ->
                            val viewModel: PrayerTimeViewModel = hiltViewModel()
                            PrayerTimesHome(
                                dataClass = viewModel.state.value,
                                navigateToDetailScreen = {
                                    navController
                                        .navigate("${Screen.PrayerDetail.route}")
                                }
                                /*navigateToDetailScreen = { id ->
                                    navController
                                        .navigate("${Screen.PrayerDetail.route}/$id")
                                }*/
                            )
                        }
                        composable(
                            route = Screen.PrayerDetail.route,
                            arguments = Screen.PrayerDetail.arguments
                        ) { it ->
                            val viewModel: PrayerTimeViewModel = hiltViewModel()
                            PrayerDetailScreen(
//                                prayerId = ""
                            )
                        }
                    }

                )


            }
        }
    }
}



