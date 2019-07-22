package com.example.andriod.android_navigation

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendFakeNotification()
    }

    private fun sendFakeNotification(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", importance)
            notificationManager.createNotificationChannel(channel)
        }

        val args = HomeFragmentArgs.Builder(0).build().toBundle()

        val pendingIntent = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.homeFragment)
            .setArguments(args)
            .createPendingIntent()

        val notification = Notification.Builder(this)
            .setContentTitle("Now on sale")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.backpack)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            notification.setChannelId("channel0")
        }
        notificationManager.notify(0, notification.build())

    }
}
