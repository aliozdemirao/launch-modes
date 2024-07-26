package com.aliozdemir.launchmodes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}