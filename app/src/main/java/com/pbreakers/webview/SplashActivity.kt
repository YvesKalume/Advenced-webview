package com.pbreakers.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : Thread() {
            override fun run() {
                Thread.sleep(1500)

                startActivity(Intent(baseContext, MainActivity::class.java))
                finish()
            }
        }.start()
    }
}
