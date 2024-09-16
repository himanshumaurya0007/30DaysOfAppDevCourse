package com.example.useofapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var rvItem: RecyclerView
    lateinit var myCustomRVAdapter: MyCustomRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItem = findViewById(R.id.rvItem)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<Data?> {

            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                val responseBody = response.body()

                if (responseBody != null) {
                    val productList = responseBody.products

                    if (productList.isNotEmpty()) {
                        myCustomRVAdapter = MyCustomRVAdapter(this@MainActivity, productList)
                        rvItem.adapter = myCustomRVAdapter
                        rvItem.layoutManager = LinearLayoutManager(this@MainActivity)
                    } else {
                        Log.d("MainActivity", "Product list is empty.")
                    }
                } else {
                    Log.d("MainActivity", "Response body is null.")
                }
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Log.d("MainActivity", "API call failed: ${t.message}")
            }
        })
    }
}