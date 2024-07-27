package com.aliozdemir.launchmodes.singleinstance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

class ThirdActivitySingleInstance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_third_single_instance)
    }
}
