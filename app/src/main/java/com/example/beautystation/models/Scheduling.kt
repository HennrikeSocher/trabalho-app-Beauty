package com.example.beautystation.models
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "scheduling_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Scheduling (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val userId: Long, // espero que relacionamento funcione assim aqui
    val professional: String,
    val date: String, // mudar para Date
    val time: String, // mudar para Date
)