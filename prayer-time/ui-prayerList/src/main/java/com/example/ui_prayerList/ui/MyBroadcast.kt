package com.example.ui_prayerList.ui

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.SyncStateContract.Constants
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.multimodule.R


class MyBroadcast : BroadcastReceiver() {


    private lateinit var notificationManager: NotificationManager
    lateinit var mediaPlayer: MediaPlayer

    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("MyBroadcast", "Playing media player")


        context?.let {

//            mediaPlayer = CreateMediaPlayer(context)

//            start(context)

//            startServiceBindWithNotification(context)
        }


        /*val stopIntent: Intent = Intent(
            context,
            MyService::class.java
        )
        stopIntent.action = Constants.ACTION.STOPFOREGROUND_ACTION
*/

    }

    private fun start(context: Context) {



//        val intent = Intent(context, MyService::class.java)

//        val pendingIntent = PendingIntent.getService(
//            context, 0, intent,
//            PendingIntent.FLAG_IMMUTABLE
//        )

        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager


        val notification = NotificationCompat.Builder(context, "COUNTER_CHANNEL_ID")
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Foreground Service")
            .setContentText("This is a foreground service")
            .setOngoing(false)
//            .setContentIntent(pendingIntent)
            /*.addAction(
                NotificationCompat.Action(
                    R.drawable.sultan_qaboos_mosque,
                    "Stop",
                    PendingIntent.getService(context, 0,
                        Intent(context, MyService::class.java).
                        setAction("STOP_SERVICE"), PendingIntent.FLAG_IMMUTABLE)
                )
            )*/
            .build()


        Intent(context, MyService::class.java).also {
            it.action = MyService.Actions.START.toString()
            ContextCompat.startForegroundService(context,it)
        }

//        notificationManager.notify(1, notification)

//        context.startService(intent)
//        ContextCompat.startForegroundService(context,intent)
//        context.startForegroundService(intent)


    }



    fun CreateMediaPlayer(context: Context): MediaPlayer {

        return MediaPlayer.create(
            context,
            R.raw.azan1
        )


    }

    fun playMediaPlayer() {
        mediaPlayer?.let {
            if (!mediaPlayer.isPlaying)
                mediaPlayer.start()
            else
                mediaPlayer.pause()
        }
    }



}