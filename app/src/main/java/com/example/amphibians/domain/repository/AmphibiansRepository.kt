package com.example.amphibians.domain.repository

import com.example.amphibians.domain.model.Amphibian

interface AmphibiansRepository {

    suspend fun getAmphibiansData(): List<Amphibian>

}