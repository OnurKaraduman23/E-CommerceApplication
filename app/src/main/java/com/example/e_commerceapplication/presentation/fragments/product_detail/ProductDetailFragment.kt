package com.example.e_commerceapplication.presentation.fragments.product_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.common.extension.loadImageView
import com.example.e_commerceapplication.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val productDetailViewModel: ProductDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_product_detail,
            container,
            false
        )

        val bundle: ProductDetailFragmentArgs by navArgs()
        val productId = bundle.productId
        Log.e("Dante", productId.toString())
        productDetailViewModel.getProduct(productId)

        binding.backButton.setOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        lifecycleScope.launch {
            productDetailViewModel.state.collect { state ->
                when {
                    state.isLoading -> {
                        Log.e("Dante", "Loading")
                    }

                    state.isError.isNotBlank() -> {
                        Log.e("Dante", "error")
                    }

                    else -> state.product?.let { product ->
                        binding.imageViewDetailProduct.loadImageView(product.image)
                        binding.textViewProductName.text = product.title
                        binding.textViewProductDescription.text = product.description
                        binding.ratingBar.rating = product.productRatingDto?.rate!!.toFloat()
                        binding.textViewProductPrice.text = "$${product.price}"
                        binding.textViewProductFeatures.text = product.category
                        Log.e("Dante", "${product.title} -${product.image}")
                    }
                }

            }
        }

        return binding.root
    }


}