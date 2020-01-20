package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.leakcanary.LeakCanary

class MainActivity : MyInterface {

    lateinit var x: String

    override fun abstractMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(s: String) {}

}