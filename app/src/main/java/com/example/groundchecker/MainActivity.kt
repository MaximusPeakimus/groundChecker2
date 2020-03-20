package com.example.groundchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //hello world

        //test123

        Log.d("TEST", "Hello world")
        Log.d("TEST2", "This is also a test")
    }
}
