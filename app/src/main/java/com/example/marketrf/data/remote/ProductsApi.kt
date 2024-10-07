package com.example.marketrf.data.remote

import com.example.marketrf.data.remote.model.ProductDetailDto
import com.example.marketrf.data.remote.model.ProductDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {
    //Aquí definimos los endpoints
    //Para Apiary

    //https://private-2b3ad5-market28.apiary-mock.com/market/product_list
    @GET("market/product_list")
    fun getProductsApiary(): Call<MutableList<ProductDto>>

    //https://private-2b3ad5-market28.apiary-mock.com/market/product_detail/1
    @GET("market/product_detail/{id}")
    fun getProductDetailApiary(
        @Path("id") id: String?
    ): Call<ProductDetailDto>
}