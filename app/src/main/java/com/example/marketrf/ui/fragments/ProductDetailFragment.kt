package com.example.marketrf.ui.fragments

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketrf.application.MarketRFApp
import com.example.marketrf.data.ProductRepository
import com.example.marketrf.data.remote.model.ProductDetailDto
import com.example.marketrf.databinding.FragmentProductDetailBinding
import com.example.marketrf.utils.Constants
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val PRODUCT_ID = "product_id"

class ProductDetailFragment : Fragment() {

    private var productId: String? = null

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get()  = _binding!!

    private lateinit var repository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            productId = args.getString(PRODUCT_ID)
            Log.d(Constants.LOGTAG, "Id recibido $productId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Se manda llamar ya cuando el fragment es visible en pantalla
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Obteniendo la instancia al repositorio
        repository = (requireActivity().application as MarketRFApp).repository

        productId?.let{ id ->
            //Hago la llamada al endpoint para consumir los detalles del producto

            //Para apiary
            val call: Call<ProductDetailDto> = repository.getProductDetailApiary(id)

            call.enqueue(object: Callback<ProductDetailDto>{
                override fun onResponse(p0: Call<ProductDetailDto>, response: Response<ProductDetailDto>) {

                    binding.apply {
                        pbLoading.visibility = View.GONE

                        //Aquí utilizamos la respuesta exitosa y asignamos los valores a las vistas
                        tvTitle.text = response.body()?.title

                        Glide.with(requireActivity())
                            .load(response.body()?.image)
                            .into(ivImage)

                        tvDescription.text = response.body()?.description

                        //Para justificar el texto de un textview
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) //Q corresponde a Android 10
                            tvDescription.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD

                        tvStatus.text = response.body()?.status
                        tvWidth.text  = response.body()?.width
                        tvLength.text = response.body()?.length
                        tvHeight.text = response.body()?.height
                    }

                }

                override fun onFailure(p0: Call<ProductDetailDto>, p1: Throwable) {
                    //Manejo del error de conexión
                }

            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(productId: String) =
            ProductDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(PRODUCT_ID, productId)
                }
            }
    }
}