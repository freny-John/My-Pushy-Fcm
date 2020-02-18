package com.freny.messaging.fcm.alternate

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.freny.messaging.R


object NotificationHelper {

    fun displayNotification(context: Context, title: String, body: String) {

        val intent = Intent(context, FcmAlternateActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            context,
            100,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        val mBuilder = NotificationCompat.Builder(
            context,
            FcmAlternateActivity.CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(body)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val mNotificationMgr = NotificationManagerCompat.from(context)
        mNotificationMgr.notify(1, mBuilder.build())

    }

}