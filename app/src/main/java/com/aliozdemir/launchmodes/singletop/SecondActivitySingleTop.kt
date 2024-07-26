package com.aliozdemir.launchmodes.singletop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aliozdemir.launchmodes.R

/**
 *      C:\Users\ali\AppData\Local\Android\Sdk\platform-tools\adb shell dumpsys activity activities | findstr "Hist"
 *
 *      2. Single Top:
 *
 *      Eğer singleTop olarak ayarlanmış olan activity hali hazırda backstack'te bulunuyor ve
 *      backstack'in en üstünde yer alıyorsa (kullaniciya görünen activity ise) bu durumda,
 *      aynı activity'i tekrardan startActivity ile çağırmak o activity'nin sıfırdan yeni instance'ının
 *      olusturulmasını engeller.
 *      onNewIntent() fonksiyonunun yeni intent ile çağrılmasını sağlatır.
 *
 *      Ancak singleTop olarak ayarlanmis olan activity hali hazırda backstack'te bulunmuyorsa,
 *      ya da bulunuyor ama top activity degilse, bu durumda standart akış devam eder.
 *      Yani yeni instance'ı sıfırdan oluşacak ve backstack'e eklenecektir.
 *
 *      FLAG_ACTIVITY_SINGLE_TOP flag'i ile singleTop launchMode'u ile aynı işi yapar.
 */

class SecondActivitySingleTop : AppCompatActivity() {

    private lateinit var btnOpenMainActivity: Button
    private lateinit var btnOpenSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second_single_top)

        btnOpenMainActivity = findViewById(R.id.btnOpenMainActivity)
        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)

        btnOpenMainActivity.setOnClickListener {
            startActivity(Intent(this, MainActivitySingleTop::class.java))
        }

        btnOpenSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivitySingleTop::class.java))
        }

//        btnOpenSecondActivity.setOnClickListener {
//            val intent = Intent(this, SecondActivitySingleTop::class.java).apply {
//                flags = FLAG_ACTIVITY_SINGLE_TOP
//            }
//            startActivity(intent)
//        }
    }

    override fun onNewIntent(intent: Intent) {  // onNewIntent'e girmesi, onCreate çalışmadı anlamına gelir.
        super.onNewIntent(intent)

        Toast.makeText(this, "New Intent", Toast.LENGTH_SHORT).show()
    }
}