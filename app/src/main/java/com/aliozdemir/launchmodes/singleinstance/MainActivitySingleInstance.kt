package com.aliozdemir.launchmodes.singleinstance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

class MainActivitySingleInstance : AppCompatActivity() {
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_single_instance)

        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleInstance::class.java))
        }
    }
}
