package com.example.ui_prayerList.ui

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import com.example.domain.Data
import com.example.domain.Timings
import com.example.domain.toMap
import com.example.multimodule.R
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Calendar
import kotlin.random.Random

@Composable
fun PrayerTimesHome(
    dataClass: PrayerTimesHomeState,
    navigateToDetailScreen: () -> Unit
//    navigateToDetailScreen: (Int) -> Unit
) {


    val context = LocalContext.current

    val customView: View =
        LayoutInflater.from(context)
            .inflate(R.layout.notification_layout, null)


    val largeIconView = customView.findViewById<Button>(
        R.id.cancel_btn)

    largeIconView.setOnClickListener{
        println("clicked how")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {

        Card {

            Column(
                Modifier
                    .fillMaxSize()
            ) {
                ImageFade(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.4f),
                    dataClass
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.3f),
                    Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                         scheduleAlarm(context,dataClass.currentData)

                    }) {
                        Text("Press")

                    }

                }

                dataClass.currentData?.let {
                    PrayerNameAndTime(
                        Modifier.fillMaxSize(),
                        it.timings,
                        navigateToDetailScreen,
                    )
                }

            }


        }

    }

}



fun scheduleAlarm(context: Context,data:Data) {
    val calendar = Calendar.getInstance()

    calendar.set(Calendar.HOUR_OF_DAY, 13)
    calendar.set(Calendar.MINUTE, 47)
    calendar.set(Calendar.SECOND, 30)

//    val intent = Intent(context, MyBroadcast::class.java)
    val intent = Intent(context, MyService::class.java)

    val bundle = Bundle()
    bundle.putParcelable("data", data)

//    val pendingIntent = PendingIntent.getBroadcast(
    val pendingIntent = PendingIntent.getService(
        context,
        0,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or
                PendingIntent.FLAG_IMMUTABLE,
    )


    val alarmManager = context.getSystemService(Context.ALARM_SERVICE)
            as AlarmManager


    /*alarmManager.set(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        pendingIntent
    )*/
    alarmManager.set(
        AlarmManager.RTC_WAKEUP,
        SystemClock.elapsedRealtime() + 1 * 60 * 1000,
        pendingIntent
    )


}



@Composable
fun PrayerNameAndTime(
    modifier: Modifier,
    timings: Timings?,
    navigateToDetailScreen: () -> Unit
) {
    val list = timings?.toMap()?.toList()
    print("myMap ${timings?.toMap()}")
    LazyColumn(
        modifier
            .background(Color.DarkGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        items(list?.size ?: 0) { index ->
            PrayerListItem(
                timings,
                index,
                onSelectItem = {
                    navigateToDetailScreen()
                }
            )

        }
    }
}

@Composable
fun PrayerListItem(
    timings: Timings?,
    index: Int,
    onSelectItem: (Int) -> Unit
) {
    Row(
        Modifier
            .fillMaxSize(),
        Arrangement.SpaceBetween
    ) {
        print("myMap2 ${timings?.toMap()?.keys?.toList()?.get(1)}")

        val key = timings?.toMap()?.keys?.toList()?.get(index).toString()
        val value = timings!!.toMap().get(key)
        Text(
            text = key,
            fontWeight = FontWeight.W700,
            fontSize = 22.sp, color = Color.White
        )
        value?.substringBefore(" ")?.let {
            Text(
                text = it,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }

}

@Composable
fun ImageFade(modifier: Modifier, dataClass: PrayerTimesHomeState) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.sultan_qaboos_mosque),
            contentDescription = "content description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.7f))
        )
        Column(
            Modifier
                .wrapContentSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Time remaining:",
                style = TextStyle(
                    color = Color.White, fontSize = 20.sp,
                ),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = calculateTheRemaining(dataClass),
                style = TextStyle(color = Color.White, fontSize = 40.sp),

                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black, fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.weight(1f))
            DateAndLocation(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }

    }
}

@Composable
fun DateAndLocation(modifier: Modifier) {
    Row(modifier = modifier.padding(10.dp), Arrangement.SpaceBetween) {
        val style = TextStyle(
            color = Color.White,
            fontSize = 15.sp,
        )
        Text(text = "22/9/23", style = style)
        Text(text = "London", style = style)
    }
}

fun calculateTheRemaining(dataClass: PrayerTimesHomeState): String {

    return dataClass.currentData?.timings?.Maghrib?.substringBefore(" ") + ":00"
    return "00:00:00"
}


enum class TimeName {
    Fajr, Sunrise, Dhuhr, Asr, Maghrib, Isha,
}

