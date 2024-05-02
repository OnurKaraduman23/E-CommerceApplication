package com.example.e_commerceapplication.presentation.fragments.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentProductsBinding
import com.example.e_commerceapplication.presentation.adapters.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private val productViewModel: ProductsViewModel by viewModels()
    private lateinit var  productsAdapter: ProductsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_products, container, false)

        productsAdapter = ProductsAdapter {
            val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailFragment(it)
            findNavController().navigate(action)
        }
        setupRv()
        collectUIState()

        return binding.root


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
                            productsAdapter.setData(it.products)

                        }
                    }

                }



            }
        }
    }

    private fun setupRv(){
        binding.rVProducts.adapter = productsAdapter
        binding.rVProducts.layoutManager = GridLayoutManager(requireContext(), 2)
    }


}