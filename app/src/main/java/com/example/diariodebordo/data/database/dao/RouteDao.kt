package com.example.diariodebordo.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.diariodebordo.data.database.entity.Route

@Dao
interface RouteDao {

    @Insert
    suspend fun insertRoute(route : Route)

    @Query("SELECT * FROM route")
    suspend fun getAllRoutes(): List<Route>

    @Query("SELECT * FROM route WHERE driverId = :driverId")
    suspend fun getRoutesByDriver(driverId : Long): List<Route>

    @Update
    suspend fun updateRoute(route : Route)

    @Delete
    suspend fun deleteRoute(route : Route)
    
}