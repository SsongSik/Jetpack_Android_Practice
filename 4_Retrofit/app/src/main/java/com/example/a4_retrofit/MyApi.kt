package com.example.a4_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    @GET("posts/1")
    fun getPost1() : Call<Post>

    @GET("posts/{number}")
    fun getPostNumber(
        @Path("number") number : Int
    ) : Call<Post>

}