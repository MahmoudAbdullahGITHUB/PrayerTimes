package com.example.ui_prayerList.ui

import com.example.core.domain.ProgressBarState
import com.example.domain.Data

data class PrayerTimesHomeState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val currentData: Data? =null
)
