package com.example.diariodebordo.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.diariodebordo.data.database.converters.Converters
import com.example.diariodebordo.data.database.dao.CarDao
import com.example.diariodebordo.data.database.dao.DriverDao
import com.example.diariodebordo.data.database.dao.RouteDao
import com.example.diariodebordo.data.database.entity.Driver
import com.example.diariodebordo.data.database.entity.Car
import com.example.diariodebordo.data.database.entity.Route

@Database(entities = [Driver::class, Car::class, Route::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase :RoomDatabase(){
  abstract fun routeDao() : RouteDao
  abstract fun driverDao() : DriverDao
  abstract fun carDao() : CarDao
}

object DatabaseSingleton {
  private var INSTANCE : AppDatabase? = null

  fun getDatabase(context : Context) : AppDatabase{
    return INSTANCE ?: synchronized(this){
      val instance = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "app_database"
      ).fallbackToDestructiveMigration().build() //TODO remover o fallbackToDestrcutiveMigration ao lançar o app
      INSTANCE = instance
      instance
    }
  }
}