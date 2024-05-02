package com.example.e_commerceapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapplication.common.ProductsDiffUtil
import com.example.e_commerceapplication.databinding.ProductsRowLayoutBinding
import com.example.e_commerceapplication.domain.model.Products

class ProductsAdapter(private val onItemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    private var productLists = emptyList<Products>()

    class MyViewHolder(private val binding: ProductsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Products,onItemClickListener: (Int) -> Unit) {
            binding.objectProduct = product
            binding.ratingPoint = product.ratingDto?.rate.toString()
            binding.ratingBar.rating = product.ratingDto?.rate!!.toFloat()
            binding.cardViewProduct.setOnClickListener {
                onItemClickListener.invoke(product.id!!)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductsRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return productLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productLists[position]
        holder.bind(currentItem,onItemClickListener)
    }

    fun setData(newData: List<Products>) {
        val coinsDiffUtil = ProductsDiffUtil(productLists, newData)
        val diffUtilResult = DiffUtil.calculateDiff(coinsDiffUtil)
        productLists = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }
}