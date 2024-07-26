package com.aliozdemir.launchmodes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var btnOpenMainActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        btnOpenMainActivity = findViewById(R.id.btnOpenMainActivity)
        btnOpenMainActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}