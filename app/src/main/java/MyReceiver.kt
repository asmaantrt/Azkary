package com.app.azkarapp
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.ServiceCompat.STOP_FOREGROUND_DETACH
import androidx.core.app.ServiceCompat.stopForeground

class MyReceiver : BroadcastReceiver() {

override fun onReceive(context : Context, intent : Intent){
    Log.d("day" , counter.toString()+"onReceive")
    // For our recurring task, we'll just display a message
   // Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
   // Log.d("Calendar" , "onReceive")
    val notificationIntent = Intent(context, MainActivity::class.java)
    //notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP


    val pendingIntent = PendingIntent.getActivity(context , 0 , Intent(context, MainActivity::class.java) , PendingIntent.FLAG_UPDATE_CURRENT)

    val builder = NotificationCompat.Builder(context.applicationContext, "notifylemubit")
        .setContentTitle("الأذكار اليومية")
        .setContentText("هل قرأت أذكارك اليوم؟")
        .setSmallIcon(R.drawable.icon1)
        //.setSound()
       // .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .addAction(R.drawable.icon1 , "فتح" ,pendingIntent)
        .setAutoCancel(true)
        .setOngoing(false)

         // here we are passing the pending intent
      //  .setContentIntent(pendingIntent)

    val notificationManager = NotificationManagerCompat.from(context)
    notificationManager.notify(1 , builder.build())

}}