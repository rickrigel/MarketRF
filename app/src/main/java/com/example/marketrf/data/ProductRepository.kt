package com.example.marketrf.data

import com.example.marketrf.data.remote.ProductsApi
import com.example.marketrf.data.remote.model.ProductDetailDto
import com.example.marketrf.data.remote.model.ProductDto
import retrofit2.Call
import retrofit2.Retrofit

class ProductRepository (
    private val retrofit: Retrofit
) {

    private val productsApi: ProductsApi = retrofit.create(ProductsApi::class.java)

    //Para Apiary
    fun getProductsApiary(): Call<MutableList<ProductDto>> = productsApi.getProductsApiary()

    fun getProductDetailApiary(id: String?): Call<ProductDetailDto> =
        productsApi.getProductDetailApiary(id)
}