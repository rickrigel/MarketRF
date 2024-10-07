package com.example.marketrf.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductDto(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("thumbnail")
    var thumbnail: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("brand")
    var brand: String? = null,

    @SerializedName("publication")
    var publication: String? = null,

    @SerializedName("location")
    var location: String? = null,

    @SerializedName("price")
    var price: String? = null

)
