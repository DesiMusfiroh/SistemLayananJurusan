package com.layanan.jurusan.data.remote.api

import com.layanan.jurusan.data.remote.response.ListNewsResponse
import com.layanan.jurusan.data.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("/")
    fun login(
            @Field("post_username") username: String,
            @Field("post_password") password: String
    ) : Call<UserResponse>

    @GET("")
    fun getLatestNews(): Call<ListNewsResponse>
}