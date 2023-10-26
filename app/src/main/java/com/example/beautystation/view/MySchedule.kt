package com.example.beautystation.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beautystation.R

class MySchedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_schedule)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#DC98C0")
    }
}