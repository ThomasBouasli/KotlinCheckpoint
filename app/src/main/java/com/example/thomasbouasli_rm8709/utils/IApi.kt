package com.example.thomasbouasli_rm8709.utils

import com.example.thomasbouasli_rm8709.models.Comment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface IApi {
    @GET("posts/1/comments")
    fun getComments(): Call<List<Comment>>
}