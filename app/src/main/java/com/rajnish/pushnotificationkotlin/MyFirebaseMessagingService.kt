package com.rajnish.pushnotificationkotlin

import android.R
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioAttributes;
import android.os.Build
import android.util.Log;
import androidx.core.app.NotificationCompat

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


class MyFirebaseMessagingService :FirebaseMessagingService()
{
    val TAG = "Service"
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        val type = getSharedPreferences(
            "login_info",
            Context.MODE_PRIVATE
        ).getInt("usertype", -1)

        val data = remoteMessage!!.data
        val body = data["body"]
        val title = data["title"]

        println("Body$body")
        println("Body$title")

        val intent: Intent
    }

    override fun onNewToken(p0: String?) {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                // Get new Instance ID token
                val token = task.result!!.token
                Log.e("My Token", token)
            })
    }

}