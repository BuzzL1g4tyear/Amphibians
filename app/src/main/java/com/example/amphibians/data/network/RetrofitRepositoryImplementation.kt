package com.example.amphibians.data.network

import com.example.amphibians.domain.model.Amphibian
import com.example.amphibians.domain.repository.AmphibiansRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class RetrofitRepositoryImplementation : AmphibiansRepository {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: NetworkApi by lazy {
        retrofit.create(NetworkApi::class.java)
    }

    override suspend fun getAmphibiansData(): List<Amphibian> {
        return retrofitService.getAmphibiansApi()
    }
}