package com.freny.messaging.fcm.alternate

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.freny.messaging.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main_alternate.*


class FcmAlternateActivity : AppCompatActivity() {

    //Defined the required values
    companion object {
        const val CHANNEL_ID = "freny_coding"
        private const val CHANNEL_NAME = "freny Coding"
        private const val CHANNEL_DESC = "Android Push Notification"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alternate)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                progressbar.visibility = View.INVISIBLE

                if (!task.isSuccessful) {
                    textViewToken.text = task.exception?.message
                    return@OnCompleteListener
                }

                val token = task.result?.token

                textViewMessage.text = "Your FCM Token is:"
                textViewToken.text = token

                Log.d("Token", token)

            })


        //creating notification channel if android version is greater than or equals to oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description =
                CHANNEL_DESC
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        //opening dashboard
        buttonOpenDashboard.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("http://bit.ly/2GEIPlu")
            startActivity(i)
        }

        //copying the token
        buttonCopyToken.setOnClickListener {
            //            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//            val clip = ClipData.newPlainText("token", textViewToken.text)
//            clipboard.primaryClip = clip


            val clipboard =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("token", textViewToken.text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this@FcmAlternateActivity, "Copied", Toast.LENGTH_LONG).show()


        }
    }
}

