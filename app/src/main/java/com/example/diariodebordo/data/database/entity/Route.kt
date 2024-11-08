package com.example.diariodebordo.data.database.entity

import android.widget.TimePicker
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "route",
    /*foreignKeys = [
        ForeignKey(entity = Driver::class, parentColumns = ["driverId"], childColumns = ["driverId"]),
        ForeignKey(entity = Car::class, parentColumns = ["carId"], childColumns = ["carId"])
    ]*/
)

data class Route(
    @PrimaryKey(autoGenerate = true)
    val routeId: Long? = null,
    val driverId: Long,          // Referência à tabela Driver
    val carId: Long,             // Referência à tabela Car
    val initialMileage: Int,  // Quilometragem inicial
    val finalMileage: Int, // Quilometragem final
    //val dateTime: LocalDateTime = LocalDateTime.now()
    // outros campos do trajeto caso sejam necessários no futuro
)