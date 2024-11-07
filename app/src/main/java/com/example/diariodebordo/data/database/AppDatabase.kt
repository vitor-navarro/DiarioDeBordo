package com.example.diariodebordo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.diariodebordo.data.database.dao.RouteDao
import com.example.diariodebordo.data.database.entity.Driver
import com.example.diariodebordo.data.database.entity.Car
import com.example.diariodebordo.data.database.entity.Route

@Database(entities = [Driver::class, Car::class, Route::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
  abstract fun routeDao() : RouteDao
}