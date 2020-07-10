package com.rithikjain.winualltask.network

import com.rithikjain.winualltask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    fun createRetrofit(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}