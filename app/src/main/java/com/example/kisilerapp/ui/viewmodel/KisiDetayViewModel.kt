package com.example.kisilerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisilerapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor (var kRepo : KisilerRepository) : ViewModel() {

     fun guncelle(kisi_id: Int,kisi_ad: String,kisi_tel : String){
       CoroutineScope(Dispatchers.Main).launch {
           kRepo.kaydet(kisi_ad,kisi_tel)
       }
    }
}