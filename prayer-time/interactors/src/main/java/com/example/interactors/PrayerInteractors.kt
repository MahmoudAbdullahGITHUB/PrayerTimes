package com.example.interactors

import com.example.datasource.network.IPrayerTimeService


data class PrayerInteractors(
    val getPrayerTimesUseCase: GetPrayerTimesUseCase
    // TODO (add prayer times interactors)
) {
    companion object Factory {
        fun build(): PrayerInteractors {
            val service = IPrayerTimeService.build()
            return PrayerInteractors(
                getPrayerTimesUseCase = GetPrayerTimesUseCase(
                    service = service
                )
            )
        }
    }
}
