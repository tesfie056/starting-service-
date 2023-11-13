package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountDownService: Service() {


        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            val seconds = intent?.getIntExtra("seconds", 0) ?: 0

            CoroutineScope(Dispatchers.Default).launch {
                for (i in seconds downTo 0) {
                    Log.d("CountdownService", "Countdown: $i seconds")
                    delay(1000)  // Simulate counting down by delaying 1 second
                }

                stopSelf()  // Stop the service when countdown is complete
            }

            return START_NOT_STICKY
        }

        override fun onBind(intent: Intent?): IBinder? {
            return null
        }
    }


