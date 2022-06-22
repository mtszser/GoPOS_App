package com.example.goposapp.api

import com.example.goposapp.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("access_token")
    var authToken: String,

)
