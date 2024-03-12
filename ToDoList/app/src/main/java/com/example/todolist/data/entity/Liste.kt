package com.example.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "gorevler")
data class Liste(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "gorev_id") @NotNull var gorev_id:Int,
                 @ColumnInfo(name = "gorev_ad") @NotNull var gorev_ad:String) :Serializable {
}