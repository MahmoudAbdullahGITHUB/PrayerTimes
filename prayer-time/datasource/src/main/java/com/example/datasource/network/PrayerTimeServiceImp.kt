package com.example.datasource.network

import com.example.domain.PrayerTime
import retrofit2.Retrofit

class PrayerTimeServiceImp(
    private val apiService: IPrayerTimeService
) : IPrayerTimeService {
    override suspend fun getPrayerTimes(): PrayerTime {
        return apiService.getPrayerTimes()
    }
}