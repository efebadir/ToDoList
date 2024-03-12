package com.example.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.data.entity.Liste

@Dao
interface ListeDao {
    @Query("SELECT * FROM gorevler")
    suspend fun gorevleriYukle() : List<Liste>

    @Insert
    suspend fun kaydet(kisi:Liste)

    @Update
    suspend fun guncelle(kisi:Liste)

    @Delete
    suspend fun sil(kisi:Liste)

    @Query("SELECT * FROM gorevler WHERE gorev_ad like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Liste>
}