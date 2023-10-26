package com.example.beautystation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.beautystation.DAO.UserDao
import com.example.beautystation.models.Scheduling
import com.example.beautystation.models.User

@Database(entities = [User::class, Scheduling::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
//    abstract fun schedulingDao(): SchedulingDao
}
