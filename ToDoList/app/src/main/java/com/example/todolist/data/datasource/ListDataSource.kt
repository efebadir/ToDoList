package com.example.todolist.data.datasource

import android.util.Log
import com.example.todolist.data.entity.Liste
import com.example.todolist.room.ListeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListDataSource(var ldao:ListeDao) {
    suspend fun yukle() : List<Liste> =
        withContext(Dispatchers.IO) {
            return@withContext ldao.gorevleriYukle()
    }

    suspend fun guncelle(gorev_id:Int,gorev_ad:String){
        val guncellenenGorev = Liste(gorev_id, gorev_ad)
        ldao.guncelle(guncellenenGorev)
    }

    suspend fun sil(gorev_id:Int){
        val silinenGorev = Liste(gorev_id,"")
        ldao.sil(silinenGorev)
    }

    suspend fun ara(aramaKelimesi:String) : List<Liste> =
        withContext(Dispatchers.IO){
            return@withContext ldao.ara(aramaKelimesi)
        }

    suspend fun kaydet(gorev_ad:String){
        val yeniGorev = Liste(0,gorev_ad)
        ldao.kaydet(yeniGorev)
    }

}