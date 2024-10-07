package com.example.marketrf.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marketrf.data.remote.model.ProductDto
import com.example.marketrf.databinding.ProductElementBinding

class ProductViewHolder (

    private val binding: ProductElementBinding
): RecyclerView.ViewHolder(binding.root) {

// Listado de productos

    fun bind(product: ProductDto){

        binding.tvTitle.text = product.title

        //Con Glide
        Glide.with(binding.root.context)
            .load(product.thumbnail)
            .into(binding.ivThumbnail)

        binding.tvBrand.text = product.brand
        binding.tvPublication.text = product.publication
        binding.tvLocation.text = product.location
        binding.tvPrice.text = product.price

    }

}