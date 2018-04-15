package yardspoon.qadeputy.launcher

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import yardspoon.qadeputy.R

fun initialize(context: Context) {

    val launcherPendingIntent = PendingIntent.getActivity(context, 0, Intent(context, LauncherActivity::class.java), 0)

    val channelId = context.getString(R.string.qadeputy_notification_channel_id)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // TODO handle Oreo notifications channel registration https://developer.android.com/training/notify-user/build-notification.html
    }

    val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_qadeputy_crash)
            .setContentTitle("QA Deputy")
            .setContentText("At your service; touch to launch")
            .setOngoing(true)
            .setContentIntent(launcherPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    NotificationManagerCompat.from(context).notify(123, notificationBuilder.build())
}