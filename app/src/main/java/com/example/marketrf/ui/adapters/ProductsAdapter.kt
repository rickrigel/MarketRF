package com.example.marketrf.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketrf.data.remote.model.ProductDto
import com.example.marketrf.databinding.ProductElementBinding

class ProductsAdapter(
    private val products: MutableList<ProductDto>,
    private val onProductClicked: (ProductDto) -> Unit
): RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = products[position]

        holder.bind(product)

        holder.itemView.setOnClickListener {
            //Para los clicks a los productos
            onProductClicked(product)
        }

    }


}