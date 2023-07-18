package com.example.amphibians.data.network

import com.example.amphibians.domain.model.Amphibian
import retrofit2.http.GET

interface NetworkApi {
    @GET("amphibians")
    suspend fun getAmphibiansApi(): List<Amphibian>
}