package com.example.todolist.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.entity.Liste
import com.example.todolist.databinding.CardTasarimBinding
import com.example.todolist.ui.fragment.AnasayfaFragment
import com.example.todolist.ui.fragment.AnasayfaFragmentDirections
import com.example.todolist.ui.viewmodel.AnasayfaViewModel
import com.example.todolist.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ListeAdapter(var mContext: Context,
                   var toDoList: List<Liste>,
                   var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<ListeAdapter.CardTasarimHolder>() {
        inner class CardTasarimHolder(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val liste = toDoList.get(position)
        val t = holder.tasarim
        t.textViewGorev.text = liste.gorev_ad

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(list = liste)
            Navigation.gecis(it,gecis)
        }

        t.textViewSil.setOnClickListener {
            Snackbar.make(it,"${liste.gorev_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(liste.gorev_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun sil(kisi_id:Int){
        Log.e("Kişi Sil",kisi_id.toString())
    }
}