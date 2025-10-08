package com.example.excercise6.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.excercise6.R
import com.example.excercise6.model.CryptoModel
import com.example.excercise6.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://v6.exchangerate-api.com/v6/"
    private var cryptoModels : ArrayList<CryptoModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //8033422ecd3ea995431cf214
        //https://v6.exchangerate-api.com/v6/8033422ecd3ea995431cf214/latest/USD
        lowData()
    }
    private fun lowData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()
        call.enqueue(object: Callback<List<CryptoModel>>{
            override fun onResponse(call: Call<List<CryptoModel>?>, response: Response<List<CryptoModel>?>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                    }
                }
            }

            override fun onFailure(
                call: Call<List<CryptoModel>?>,
                t: Throwable
            ) {
               t.printStackTrace()
            }

        })
    }
}