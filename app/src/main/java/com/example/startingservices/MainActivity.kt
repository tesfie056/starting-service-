package com.example.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var numberEntry: EditText
    lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberEntry = findViewById(R.id.numberEntry)
        startButton = findViewById(R.id.countDown)
startButton.setOnClickListener{
    val seconds = numberEntry.text.toString().toIntOrNull() ?:0
    val serviceIntent = Intent(this, CountDownService::class.java)
    serviceIntent.putExtra("seconds", seconds)
    startService(serviceIntent)
}
    }
}


