package com.example.goposapp.api

import retrofit2.Call
import com.example.goposapp.model.Item
import com.example.goposapp.model.ItemResponse
import com.example.goposapp.util.Constants
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL.plus("token"))
    fun login(
        @Query("password") password: String,
        @Query("grant_type") value: String,
        @Query("client_secret") clientSecret: String,
        @Query("client_id") clientId: String,
        @Query("username") username: String

    ): Call<LoginResponse>


    @GET("/api/v3/27/items")
    fun getItems(@Query("access_token") accessToken: String): Call<ItemResponse>


    //?password=$password&grant_type=password&client\n" +
    //                "_secret=$clientSecret&client_id=$clientId&username=$login"
}