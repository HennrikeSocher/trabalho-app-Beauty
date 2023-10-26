package com.example.beautystation.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.beautystation.DAO.UserDao
import com.example.beautystation.models.Scheduling
import com.example.beautystation.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
//    abstract fun schedulingDao(): SchedulingDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun get(context: Context) : AppDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database.db"
                ).build()
            }
            return INSTANCE as AppDatabase
        }
    }
}
