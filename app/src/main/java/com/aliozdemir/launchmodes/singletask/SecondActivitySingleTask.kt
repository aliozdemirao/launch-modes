package com.aliozdemir.launchmodes.singletask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

/**
 *      C:\Users\ali\AppData\Local\Android\Sdk\platform-tools\adb shell dumpsys activity activities | findstr "Hist"
 *
 *      3. Single Task:
 *
 *      Sistem activity'i yeni bir Task'ın root Activity'si olarak yerlestirir ya da mevcut Task'a
 *      aynı affinity bilgisi ile yerlestirir.
 *
 *      Eger zaten stack'te aynı activity'nin instance'ı varsa yine onNewIntent()
 *      tetiklenir ve yeni bir versiyonu olusturulmaz.
 *
 *      Bu sürecte ilgili activity'nin instance'ı stack'te en yukarıda degilse,
 *      üzerinde bulunan tüm activity'ler yok edilir.
 *
 *      Eger SingleTask olarak ayarlanan activity onNewIntent() çağrısı ile çalıştırıldıysa,
 *      yeni instance'ı oluşmadığı icin back tusu, stack'teki bir alttaki activity'e döner.
 *      onNewIntent() cagrilmadan onceki state'e dönemez.
 *
 *      android:taskAffinity="com.example.blabla" gibi bir farkli affinity bilgisi varsa
 *      bu durumda startActivity ile yeni bir Task icinde root activity olarak acar.
 *      terminal log'unda t123 gibi task numarasinin farklilastigini görebiliriz.
 *
 *      FLAG_ACTIVITY_NEW_TASK flag'i aynz isi yapar.
 */

class SecondActivitySingleTask : AppCompatActivity() {
    private lateinit var btnOpenMainActivity: Button
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second_single_task)

        btnOpenMainActivity = findViewById(R.id.btnOpenMainActivity)
        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)

        btnOpenMainActivity.setOnClickListener {
            startActivity(Intent(this, MainActivitySingleTask::class.java))
        }

        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleTask::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) { // onNewIntent'e girmesi, onCreate çalışmadı anlamına gelir.
        super.onNewIntent(intent)

        Toast.makeText(this, "New Intent", Toast.LENGTH_SHORT).show()
    }
}
