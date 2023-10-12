package com.example.ui_prayerList.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Logger
import com.example.core.domain.DataState
import com.example.core.domain.UIComponent
import com.example.interactors.GetPrayerTimesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PrayerTimeViewModel @Inject constructor(
    private val getPrayerTimesUC: GetPrayerTimesUseCase
) : ViewModel() {
    val logger = Logger("PrayerTimeViewModel")
    val state: MutableState<PrayerTimesHomeState> = mutableStateOf(PrayerTimesHomeState())

    init {
        onTriggerEvents(PrayerTimeEvents.GetPrayerTimes)
    }

    fun onTriggerEvents(event: PrayerTimeEvents) {
        when (event) {
            is PrayerTimeEvents.GetPrayerTimes -> {
                getPrayerTimes()
            }
        }
    }

    fun getPrayerTimes() {
        getPrayerTimesUC.execute().onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }

                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }

                    }
                }

                is DataState.Data -> {
                    state.value = state.value.copy(currentData = dataState.data?.data!![0] ?: null)
                    println("all timings ${dataState.data?.data}")
                }

                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }

        }.launchIn(viewModelScope)
    }

}