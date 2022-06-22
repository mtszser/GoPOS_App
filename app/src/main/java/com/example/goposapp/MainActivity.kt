package com.example.goposapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.goposapp.api.*
import com.example.goposapp.databinding.ActivityMainBinding
import com.example.goposapp.model.ItemResponse
import com.example.goposapp.model.Items
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.Throwable
import kotlin.toString


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    private lateinit var objectBox: ObjectBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        binding.getDataButton.setOnClickListener {

            apiClient.getApiService().login(
                password = "zadanie",
                clientSecret = "dc6d8a5e-861b-4df8-bb6b-9889c106161d",
                clientId = "073481d0-549e-4eac-9174-27cd2432f149",
                username = "zadanie@zadanie.com",
                value = "password"

            )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        Log.d("matilogin", " asdasd${response.body().toString()}")
                        val service = RetrofitClient.build().create(ApiService::class.java)
                        val itemRequest = service.getItems(response.body()?.authToken ?: "")

                        itemRequest.enqueue(object : Callback<ItemResponse> {
                            override fun onResponse(
                                call: Call<ItemResponse>,
                                response: Response<ItemResponse>
                            ) {
                                Log.d("mati", " asdasd${response.body().toString()}")
                            }

                            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                                Log.d("mati", "${ t.message.toString()}")

                            }


                        })
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.d("mati", t.message.toString())
                    }
                }
                )



        }
    }
}