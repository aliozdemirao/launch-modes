package com.aliozdemir.launchmodes.singletask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

class MainActivitySingleTask : AppCompatActivity() {

    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_single_task)

        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleTask::class.java))
        }
    }

}