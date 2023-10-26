package com.example.beautystation

import android.app.Application
import com.example.beautystation.database.AppDatabase
import com.example.beautystation.repositories.UserRepository

class BeautyStationApp: Application() {
    private val database by lazy { AppDatabase.get(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}