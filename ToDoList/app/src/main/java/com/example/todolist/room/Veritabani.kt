package com.example.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.entity.Liste

@Database(entities = [Liste::class], version = 1)
abstract class Veritabani : RoomDatabase() {
   abstract fun getListeDao() : ListeDao
}