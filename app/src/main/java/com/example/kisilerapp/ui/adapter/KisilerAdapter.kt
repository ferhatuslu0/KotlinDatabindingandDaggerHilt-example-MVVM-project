package com.example.kisilerapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisilerapp.R
import com.example.kisilerapp.data.entity.Kisiler
import com.example.kisilerapp.databinding.CardTasarimBinding
import com.example.kisilerapp.ui.fragment.AnasayfaFragmentDirections
import com.example.kisilerapp.ui.viewmodel.AnasayfaViewModel
import com.example.kisilerapp.util.gecis
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var  mContext: Context, var mList: List<Kisiler>,var viewModel:AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardViewHolder>(){

    inner class CardViewHolder(var view: CardTasarimBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : CardTasarimBinding =
            DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kisi = mList[position]

        holder.view.kisiNesnesi = kisi

        holder.view.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ? ",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id)
                }
                .show()
        }

        holder.view.cardViewSatir.setOnClickListener {
            val pass = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecis(it,pass)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}