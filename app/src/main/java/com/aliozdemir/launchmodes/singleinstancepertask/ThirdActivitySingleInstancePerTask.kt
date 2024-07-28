package com.aliozdemir.launchmodes.singleinstancepertask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

class ThirdActivitySingleInstancePerTask : AppCompatActivity() {
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_single_instance_per_task)

        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleInstancePerTask::class.java))
        }
    }
}
