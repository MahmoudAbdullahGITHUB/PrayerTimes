package com.example.ui_prayerList.di

import com.example.interactors.GetPrayerTimesUseCase
import com.example.interactors.PrayerInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object prayerListModule {

    @Provides
    @Singleton
    fun provideUseCase(
        @Named("interactors1")
        interactors: PrayerInteractors
    ): GetPrayerTimesUseCase {
        return interactors.getPrayerTimesUseCase
    }

}