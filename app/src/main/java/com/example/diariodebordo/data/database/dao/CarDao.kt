package com.example.diariodebordo.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.diariodebordo.data.database.entity.Car

@Dao
interface CarDao {

    @Insert
    suspend fun insertCar(car : Car)

    @Query("SELECT * FROM car")
    fun getAllCars() : List<Car>

    @Query("SELECT * FROM car WHERE carId = :carId") //TODO em vez de selecionar todos deveria selecionar apenas 1, pois o mesmo carro só possui 1 id
    fun getCarByID(carId: Long): List<Car>

    @Update
    suspend fun updateCar(car : Car)

    @Delete
    suspend fun deleteCar(car : Car)
}