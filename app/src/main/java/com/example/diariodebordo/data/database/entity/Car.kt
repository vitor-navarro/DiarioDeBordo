package com.example.diariodebordo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class Car(
    @PrimaryKey(autoGenerate = true) val carId: Int = 0,
    val plate: String
)