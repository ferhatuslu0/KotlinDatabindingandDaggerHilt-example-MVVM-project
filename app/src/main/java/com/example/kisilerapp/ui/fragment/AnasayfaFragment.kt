package com.example.kisilerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisilerapp.R
import com.example.kisilerapp.data.entity.Kisiler
import com.example.kisilerapp.databinding.FragmentAnasayfaBinding
import com.example.kisilerapp.ui.adapter.KisilerAdapter
import com.example.kisilerapp.ui.viewmodel.AnasayfaViewModel
import com.example.kisilerapp.ui.viewmodel.KisiKayitViewModel
import com.example.kisilerapp.util.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment = this

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

        })


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(view:View){
        Navigation.gecis(view)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}