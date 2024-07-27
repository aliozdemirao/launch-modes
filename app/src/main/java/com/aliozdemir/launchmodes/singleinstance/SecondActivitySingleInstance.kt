package com.aliozdemir.launchmodes.singleinstance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

/**
 *      C:\Users\ali\AppData\Local\Android\Sdk\platform-tools\adb shell dumpsys activity activities | findstr "Hist"
 *
 *      4. Single Instance:
 *
 *      Aslinda mantık singleTask ile aynıdır.
 *
 *      Fakat sistem bu activity'i barindıran Task üzerinde baska bir activity'nin baslatilmasina izin vermez.
 *      Yani üzerinde bulundugu Task'in tek ve yegane üyesidir.
 *
 *      SingleInstance olarak ayarlanan bir activity'den baska standant bir activity açılırsa,
 *      bu durumda yeni açılan üçüncü activity ilk activity'nin backstack'igini paylasir ve o backstack'in
 *      en üstüne eklenir. SingleInstance olarak acilan activity'nin backstack'i bu iki activity'den farklidir.
 *
 *      Dolayısiyla, MainActivity -> SecondActivity -> ThirdActivity olarak devam ederseniz,
 *      ThirdActivity'den geriye bastığınızda, SecondActivity'e degil, Mainactivity'e donersiniz.
 *
 *      Çünkü ThirdActivity ile MainActivity aynı backstack'e sahip, SecondActivity ise farkli backstack'e sahiptir.
 *      Bunlardan tekrar SecondActivity'e dönnek isterseniz, SecondActivity'i start etmeniz yeterli.
 *      Zaten hali hazırda ayrı bir task icinde bulundugundan yeni bir instance'ı olusturulmayacak.
 *      onNewIntent() çağrılacaktır.
 *
 *      SingleTask'tan farklı olarak; taskAffinity bilgisi olmadan harici bir task'ı kesin olusturur.
 *      SingleTask ile affinity bilgisi kullanılarak olusturulan yeni task, recent app (overview) ekraninda gözükürken,
 *      SingleInstance ile glusturulan yeni task recent app (overview) kısminda gözükmez.
 *      Ama buna ragmen kesin olarak yeni bir task'in olustugunu log'lardan teyit edebiliriz.
 *
 *      Task1           ->      Task2               ->      Task1               ->      Task1
 *      MainActivity    ->      SecondActivity      ->      ThirdActivity       ->      MainActivity (back pressed)
 *
 */

class SecondActivitySingleInstance : AppCompatActivity() {
    private lateinit var btnOpenThirdActivity: Button
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second_single_instance)

        btnOpenThirdActivity = findViewById(R.id.btnOpenThirdActivity)
        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)

        btnOpenThirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivitySingleInstance::class.java))
        }

        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleInstance::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) { // onNewIntent'e girmesi, onCreate çalışmadı anlamına gelir.
        super.onNewIntent(intent)

        Toast.makeText(this, "New Intent", Toast.LENGTH_SHORT).show()
    }
}
