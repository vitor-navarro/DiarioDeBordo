package com.example.diariodebordo.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.diariodebordo.data.database.entity.Driver

@Dao
interface DriverDao {
    @Insert
    suspend fun insertCar(driver : Driver)

    @Query("SELECT * FROM driver")
    fun getAllCars() : List<Driver>

    @Query("SELECT * FROM driver WHERE driverId = :driverId") //TODO em vez de selecionar todos deveria selecionar apenas 1, pois o mesmo motorista só possui 1 id
    fun getCarByID(driverId: Long): List<Driver>

    @Update
    suspend fun updateCar(driver : Driver)

    @Delete
    suspend fun deleteCar(driver : Driver)
}