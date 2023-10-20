package com.example.thomasbouasli_rm8709.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CommentsApi{
    private val api : IApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(
            GsonBuilder().setLenient().create()
        ))
        .build()
        .create(IApi::class.java)

    fun getApi(): IApi{
        return api
    }
}