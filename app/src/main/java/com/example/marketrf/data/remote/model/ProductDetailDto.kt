package com.example.marketrf.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductDetailDto(

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("width")
    var width: String? = null,

    @SerializedName("length")
    var length: String? = null,

    @SerializedName("height")
    var height: String? = null,

    @SerializedName("video")
    var video: String? = null,

    @SerializedName("latitude")
    val latitude: Double,

    @SerializedName("longitude")
    val longitude: Double

)

