package com.example.beautystation.repositories

import androidx.annotation.WorkerThread
import com.example.beautystation.DAO.UserDao
import com.example.beautystation.models.User

class UserRepository(private val userDao: UserDao) {
    @WorkerThread
    suspend fun insert(user: User)
    {
        userDao.insert(user)
    }
}