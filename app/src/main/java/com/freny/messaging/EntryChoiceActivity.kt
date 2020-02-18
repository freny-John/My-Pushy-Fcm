package com.freny.messaging

import android.content.Intent
import com.firebase.example.internal.BaseEntryChoiceActivity
import com.firebase.example.internal.Choice
import com.freny.messaging.fcm.alternate.FcmAlternateActivity
import com.freny.messaging.fcm.java.FcmJavaActivity
import com.freny.messaging.fcm.kotlin.FcmKotlinActivity
import com.freny.messaging.pushy.PushyActivity

class EntryChoiceActivity : BaseEntryChoiceActivity() {

    override fun getChoices(): List<Choice> {
        return kotlin.collections.listOf(
        /*    Choice(
                "Java",
                "Run the Firebase Cloud Messaging quickstart written in Java.",
                Intent(this, FcmJavaActivity::class.java)
            ),
            Choice(
                "Kotlin",
                "Run the Firebase Cloud Messaging written in Kotlin.",
                Intent(this, FcmKotlinActivity::class.java)
            ),*/ Choice(
                "Pushy",
                "Run the Pushy Cloud Messaging written in Java.",
                Intent(this, PushyActivity::class.java)
            ),
            Choice(
                "Fcm alternate with channel ID",
                "Run the another implementation of Firebase Cloud Messaging written in Kotlin.",
                Intent(this, FcmAlternateActivity::class.java)
            )
        )
    }
}