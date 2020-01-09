package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.SystemClock

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SingClass.getInstance(this)

        testLeakMemory()
    }

    private fun testLeakMemory() {
        Thread(Runnable { SystemClock.sleep(200000) }).start()
    }

}