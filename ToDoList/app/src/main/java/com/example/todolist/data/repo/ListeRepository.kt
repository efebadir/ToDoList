package com.example.todolist.data.repo

import com.example.todolist.data.datasource.ListDataSource
import com.example.todolist.data.entity.Liste

class ListeRepository (var lds:ListDataSource) {

    suspend fun yukle() : List<Liste> = lds.yukle()

    suspend fun guncelle(gorev_id:Int,gorev_ad:String) = lds.guncelle(gorev_id, gorev_ad)

    suspend fun kaydet(gorev_ad:String) = lds.kaydet(gorev_ad)

    suspend fun sil(gorev_id: Int) = lds.sil(gorev_id)

    suspend fun ara(aramaKelimesi:String) : List<Liste> = lds.ara(aramaKelimesi)
}