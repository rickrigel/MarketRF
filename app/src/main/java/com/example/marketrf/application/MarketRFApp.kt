package com.example.marketrf.application

import android.app.Application
import com.example.marketrf.data.ProductRepository
import com.example.marketrf.data.remote.RetrofitHelper

class MarketRFApp: Application() {

    private val retrofit by lazy{
        RetrofitHelper().getRetrofit()
    }

    val repository by lazy {
        ProductRepository(retrofit)
    }

}

