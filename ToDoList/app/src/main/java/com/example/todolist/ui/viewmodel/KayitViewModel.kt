package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.ListeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var lrepo:ListeRepository) : ViewModel() {

    fun kaydet(gorev_ad:String){
        CoroutineScope(Dispatchers.Main).launch {
            lrepo.kaydet(gorev_ad)
        }
    }
}