package com.example.kisilerapp.data.datasource

import android.util.Log
import com.example.kisilerapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

   suspend fun kaydet(kisi_ad: String,kisi_tel : String){
        Log.e("Kişi kaydet","$kisi_ad - $kisi_tel")
    }

   suspend fun guncelle(kisi_id: Int,kisi_ad: String,kisi_tel : String){
        Log.e("Kişi guncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }
    suspend fun sil(kisi_id : Int) {
        Log.e("Kişi Sil",kisi_id.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            val mList = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")
            val k2 = Kisiler(2,"Zeynep","2222")
            val k3 = Kisiler(3,"Beyza","3333")

            mList.add(k1)
            mList.add(k2)
            mList.add(k3)

            return@withContext mList
        }

    suspend  fun ara(p0: String?) : List<Kisiler> =
        withContext(Dispatchers.IO){
            val mList = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")

            mList.add(k1)


            return@withContext mList
        }
}