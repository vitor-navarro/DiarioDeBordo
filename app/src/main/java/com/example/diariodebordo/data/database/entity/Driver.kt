package com.example.diariodebordo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver")
data class Driver(
    @PrimaryKey(autoGenerate = true) val driverId: Int = 0,
    val name: String,
    val cnh: String //driver license
)