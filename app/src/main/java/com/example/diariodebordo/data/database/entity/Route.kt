package com.example.diariodebordo.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "route",
    foreignKeys = [
        ForeignKey(entity = Driver::class, parentColumns = ["driverId"], childColumns = ["driverId"]),
        ForeignKey(entity = Car::class, parentColumns = ["carId"], childColumns = ["carId"])
    ]
)
data class Route(
    @PrimaryKey(autoGenerate = true) val routeId: Long,
    val driverId: Long,          // Referência à tabela Driver
    val carId: Long,             // Referência à tabela Car
    val initialMileage: Double,  // Quilometragem inicial
    val finalMileage: Double     // Quilometragem final
    // outros campos do trajeto caso sejam necessários no futuro
)