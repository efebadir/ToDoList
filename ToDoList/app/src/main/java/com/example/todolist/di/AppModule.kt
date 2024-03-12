package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.data.datasource.ListDataSource
import com.example.todolist.data.repo.ListeRepository
import com.example.todolist.room.ListeDao
import com.example.todolist.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideListeRepository(lds:ListDataSource) : ListeRepository {
        return ListeRepository(lds)
    }

    @Provides
    @Singleton
    fun provideListDataSource(ldao:ListeDao) : ListDataSource {
        return ListDataSource(ldao)
    }

    @Provides
    @Singleton
    fun provideListeDao(@ApplicationContext context: Context) : ListeDao {
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"todolist.sqlite")
            .createFromAsset("todolist.sqlite").build()
        return vt.getListeDao()
    }
}