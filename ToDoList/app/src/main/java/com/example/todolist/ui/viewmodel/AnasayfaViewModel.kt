package com.example.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.entity.Liste
import com.example.todolist.data.repo.ListeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var lrepo:ListeRepository) : ViewModel() {
    var toDoList = MutableLiveData<List<Liste>>()

    init {
        yukle()
    }

    fun yukle(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = lrepo.yukle()
        }
    }

    fun sil(gorev_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            lrepo.sil(gorev_id)
            yukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = lrepo.ara(aramaKelimesi)
        }
    }

}