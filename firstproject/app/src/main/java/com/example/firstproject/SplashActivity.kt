package com.example.firstproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    lateinit var build: Build
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        Handler().postDelayed(
//            {
//                var intent= Intent(this,MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            },3000)
        Thread(Runnable {
          try {
              Thread.sleep(3000)
              //Navigate to login activity
              var intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
          }catch (e:Exception){}
        }).start()
    }
}