package com.aliozdemir.launchmodes.singleinstancepertask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

/**
 *      C:\Users\ali\AppData\Local\Android\Sdk\platform-tools\adb shell dumpsys activity activities | findstr "Hist"
 *
 *      5. Single Instance Per Task:
 *
 *      Aslında bunun da mantığı singleInstance ile aynıdır.
 *      Başlatıldığı Task'in her zaman root activity'sidir.
 *
 *      SingleInstance'dan farklı olarak, kendi backstack'ine baska activity'ler eklenebilir.
 *      Ancak tekrar kendisi çağrıldığında backstack'de üstündeki tüm activity'leri öldürür.
 *
 *      SingleInstancePerTask olarak ayarlanan bir activity'den baska standart bir activity açılırsa,
 *      bu durumda yeni acilan üçüncü activity SingleInstancePerTask olan activity'nin backstack'igini paylasir
 *      ve o backstack'in en üstüne eklenir.
 *      Böylece yeni task üzerinde 2 activity ilk açılan launcher activity'nin üzerinde sadece tek activity bulunur.
 *
 *      Dolayısıyla, MainActivity -> SecondActivity -> ThirdActivity olarak devam ederseniz,
 *      ThirdActivity'den geriye bastığınızda, SecondActivity'i acarsiniz.
 *      SingleInstance da oldugu gibi MainActivity'e dönmezsiniz.
 *
 *      Cünkü en son acilan ThirdActivity ile SecondActivity aynı task üzerinde ve aynı backstack'e sahip.
 *      Launcher olarak açılan MainActivity ise farkli task üzerindeki farkli backstack'e sahiptir.
 *
 *      Bunlardan tekrar SecondActivity'e dönmek isterseniz, SecondActivity'i start etmeniz yeterli.
 *      Zaten hali hazırda ayrı bir task icinde bulundugundan yeni bir instance'i olusturulmayacak.
 *      onNewIntent() çağrılacaktır.
 *
 *      singleTask ve singleInstancePerTask Task üzerindeki stack'te kendilerinden önde bulunan activity'leri silerler.
 *
 *      Fakat bu durumda backstack'te en üstte yer almıyorsa, üstündeki tüm activity'ler silinecektir.
 *
 *
 *      Ancak bu activity'i FLAG_ACTIVITY_MULTIPLE_TASK veya FLAG_ACTIVITY_NEW_DOCUMENT
 *      flag'leri ile acarsak farklı Task'lar üzerinde birden fazla instance'ı bulunabilir.
 *      Yani, her yeni task'ın başına 1 instance olur.
 *
 */

class SecondActivitySingleInstancePerTask : AppCompatActivity() {
    private lateinit var btnOpenThirdActivity: Button
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second_single_instance_per_task)

        btnOpenThirdActivity = findViewById(R.id.btnOpenThirdActivity)
        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)

        btnOpenThirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivitySingleInstancePerTask::class.java))
        }

        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleInstancePerTask::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) { // onNewIntent'e girmesi, onCreate çalışmadı anlamına gelir.
        super.onNewIntent(intent)

        Toast.makeText(this, "New Intent", Toast.LENGTH_SHORT).show()
    }
}
