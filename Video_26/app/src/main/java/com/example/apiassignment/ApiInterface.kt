package com.example.apiassignment

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProductData() : Call<Data>
}