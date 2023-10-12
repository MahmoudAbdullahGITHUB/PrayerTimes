package com.example.interactors

import com.example.core.domain.DataState
import com.example.core.domain.ProgressBarState
import com.example.core.domain.UIComponent
import com.example.datasource.network.IPrayerTimeService
import com.example.domain.PrayerTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


// use case
class GetPrayerTimesUseCase(
    private val service: IPrayerTimeService,
) {

    fun execute(): Flow<DataState<PrayerTime>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            delay(1000)

            val times: PrayerTime = try {
                service.getPrayerTimes()
            } catch (e: Exception) {
                e.printStackTrace()
                emit(
                    DataState.Response<PrayerTime>(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "UnKnown Error"
                        )
                    )
                )
                PrayerTime(0, listOf(), "")
            }


            // TODO : Caching
            emit(DataState.Data(data = times))

        } catch (e: Exception) {
            e.printStackTrace()

            emit(
                DataState.Response<PrayerTime>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "UnKnown Error"
                    )
                )
            )
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }



}