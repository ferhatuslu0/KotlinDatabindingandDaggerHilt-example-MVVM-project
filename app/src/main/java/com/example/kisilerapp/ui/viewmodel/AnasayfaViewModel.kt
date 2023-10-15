package com.example.kisilerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisilerapp.data.entity.Kisiler
import com.example.kisilerapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var kRepo : KisilerRepository) : ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }

    fun sil(kisi_id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.sil(kisi_id)
            kisileriYukle()
        }
    }

    fun kisileriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kRepo.kisileriYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.ara(aramaKelimesi)
        }
    }
}