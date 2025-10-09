package com.example.excercise6.service


import com.example.excercise6.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
    //https://v6.exchangerate-api.com/v6/
    // 8033422ecd3ea995431cf214/latest/USD
    @GET("8033422ecd3ea995431cf214/latest/USD")
    suspend fun getData(): Response<List<CryptoModel>>
}
