package com.example.beautystation.DAO
import androidx.room.Dao
import androidx.room.Insert
import com.example.beautystation.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}
