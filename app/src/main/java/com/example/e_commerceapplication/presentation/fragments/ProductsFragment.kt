package com.example.e_commerceapplication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.e_commerceapplication.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private val productViewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        collectUIState()
        return inflater.inflate(R.layout.fragment_products, container, false)


    }

    private fun collectUIState() {

        lifecycleScope.launch {
            productViewModel.state.collect{
                when{
                    it.isLoading -> {

                    }
                    it.isError.isNotBlank() -> {

                    }
                    it.products.isNotEmpty() -> {
                        withContext(Dispatchers.Main) {

                        }
                    }

                }



            }
        }
    }


}