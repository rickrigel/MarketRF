package com.example.marketrf.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketrf.R
import com.example.marketrf.application.MarketRFApp
import com.example.marketrf.data.ProductRepository
import com.example.marketrf.data.remote.model.ProductDto
import com.example.marketrf.databinding.FragmentProductsListBinding
import com.example.marketrf.ui.adapters.ProductsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsListFragment : Fragment() {

    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Obteniendo la instancia al repositorio
        repository = (requireActivity().application as MarketRFApp).repository


        //Para apiary
        val call: Call<MutableList<ProductDto>> = repository.getProductsApiary()

        call.enqueue(object: Callback<MutableList<ProductDto>>{
            override fun onResponse(
                p0: Call<MutableList<ProductDto>>,
                response: Response<MutableList<ProductDto>>
            ) {
                binding.pbLoading.visibility = View.GONE

                response.body()?.let{ products ->

                    //Le pasamos los productos al recycler view y lo instanciamos
                    binding.rvProducts.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = ProductsAdapter(products){ product ->
                            //Aquí realizamos la acción para ir a ver los detalles del producto
                            product.id?.let{ id ->
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.fragment_container, ProductDetailFragment.newInstance(id))
                                    .addToBackStack(null)
                                    .commit()
                            }
                        }
                    }

                }
            }

            override fun onFailure(p0: Call<MutableList<ProductDto>>, p1: Throwable) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.txtSinConexion),
                    Toast.LENGTH_SHORT
                ).show()
                binding.pbLoading.visibility = View.GONE
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}