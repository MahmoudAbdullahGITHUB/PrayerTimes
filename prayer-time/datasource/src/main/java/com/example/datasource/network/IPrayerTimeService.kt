package com.example.datasource.network

import com.example.domain.PrayerTime
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IPrayerTimeService {

    @GET("2017/4?latitude=51.508515&longitude=-0.1254872&method=2")
    suspend fun getPrayerTimes(): PrayerTime

    companion object Factory {
        fun build(): IPrayerTimeService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY // Set the desired log level
            }
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(EndPoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return PrayerTimeServiceImp(
                apiService = retrofit.create(IPrayerTimeService::class.java)
            )
        }
    }
}