package com.example.kisilerapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.kisilerapp.ui.fragment.AnasayfaFragmentDirections

fun Navigation.gecis(it:View){
    val action = AnasayfaFragmentDirections.kisiKayitGecis()
    findNavController(it).navigate(action)
}

fun Navigation.gecis(it:View,navDirection:NavDirections){
    findNavController(it).navigate(navDirection)
}