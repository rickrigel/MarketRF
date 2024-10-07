package com.example.marketrf.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marketrf.R
import com.example.marketrf.data.ProductRepository
import com.example.marketrf.data.remote.RetrofitHelper
import com.example.marketrf.data.remote.model.ProductDto
import com.example.marketrf.databinding.ActivityMainBinding
import com.example.marketrf.ui.fragments.ProductsListFragment
import com.example.marketrf.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
/*
    private lateinit var repository: ProductRepository
    private lateinit var retrofit: Retrofit
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_MarketRF)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Mostramos el fragment inicial ProductsListFragment
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsListFragment())
                .commit()
        }

/*
        //Obteniendo la instancia de retrofit
        retrofit = RetrofitHelper().getRetrofit()

        //Obteniendo el repositorio
        repository = ProductRepository(retrofit)
*/
    }

/*
    fun click(view: View) {
        val call: Call<MutableList<ProductDto>> = repository.getProductsApiary()

        call.enqueue(object : Callback<MutableList<ProductDto>> {
            override fun onResponse(
                call: Call<MutableList<ProductDto>>,
                response: Response<MutableList<ProductDto>>
            ) {
                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.body()}")
            }

            override fun onFailure(p0: Call<MutableList<ProductDto>>, p1: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Error: No hay conexión disponible",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
 */

}