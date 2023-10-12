package com.example.ui_prayerList.ui

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.multimodule.R
import java.util.Calendar

class MyService : Service() {
    lateinit var mediaPlayer: MediaPlayer
    private lateinit var notificationManager: NotificationManager


    override fun onCreate() {
        super.onCreate()
        mediaPlayer = createMediaPlayer(this)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        Log.d("MyService", "Playing media player")


    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
            else -> start()
        }
        println("action is ${intent?.getIntExtra("key", 0)}")

        return START_NOT_STICKY
    }


    private fun start() {

        if (!mediaPlayer.isPlaying)
            mediaPlayer.start()
        else
            mediaPlayer.pause()


        val intent = Intent(this, MyService::class.java)
        intent.action = Actions.STOP.toString()
        val deletePendingIntent = PendingIntent.getService(
            this, 1, intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val remoteViews = RemoteViews(
            packageName,
            R.layout.notification_layout
        )
        remoteViews.setOnClickPendingIntent(
            R.id.cancel_btn,
            deletePendingIntent
        )


        val notification = NotificationCompat.Builder(this, "COUNTER_CHANNEL_ID")
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Foreground Service")
            .setContentText("This is a foreground service")
            .setOngoing(false)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.baseline_keyboard_arrow_down_24
                )
            )
            .setCustomContentView(remoteViews)
            .build()


        startForeground(1, notification)

        scheduleTheNextPrayer()

    }


    private fun scheduleTheNextPrayer(){
        val calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, 13)
        calendar.set(Calendar.MINUTE, 47)
        calendar.set(Calendar.SECOND, 30)

         val intent = Intent(this, MyService::class.java)

         val pendingIntent = PendingIntent.getService(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or
                    PendingIntent.FLAG_IMMUTABLE,
        )


        val alarmManager = this.getSystemService(Context.ALARM_SERVICE)
                as AlarmManager


        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            SystemClock.elapsedRealtime() + 1 * 60 * 1000,
            pendingIntent
        )
    }

    private fun createMediaPlayer(context: Context?): MediaPlayer {
        return MediaPlayer.create(
            context,
            R.raw.azan3
        )
    }


    // ------- not needed now -------
    override fun onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
        Log.d("MyService", "onDestroy: InsideService")

        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("TAG", "onBind: ")
        throw UnsupportedOperationException(
            "This Service is Bind to" +
                    "a specific Activity and it'll be killed once dead of it's " +
                    "activity"
        )
    }

    enum class Actions {
        START, STOP
    }
}


//TODO:
// mediaPlayer.setOnCompletionListener {
//            stopSelf()
// }
