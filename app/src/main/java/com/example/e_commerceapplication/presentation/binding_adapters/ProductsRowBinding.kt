package com.example.e_commerceapplication.presentation.binding_adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.e_commerceapplication.R

class ProductsRowBinding {

    companion object {
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadingImageFromUrl(imageView: ImageView, imageUrl : String){
            imageView.load(imageUrl){
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
        }
    }
}