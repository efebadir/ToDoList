package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.ListeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var lrepo:ListeRepository) : ViewModel() {

    fun guncelle(gorev_id:Int,gorev_ad:String){
        CoroutineScope(Dispatchers.Main).launch {
            lrepo.guncelle(gorev_id, gorev_ad)
        }
    }
}