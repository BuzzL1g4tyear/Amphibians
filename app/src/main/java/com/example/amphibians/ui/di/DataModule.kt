package com.example.amphibians.ui.di

import com.example.amphibians.data.network.RetrofitRepositoryImplementation
import com.example.amphibians.domain.repository.AmphibiansRepository
import org.koin.dsl.module

val dataModule = module {

    single<AmphibiansRepository> {
        RetrofitRepositoryImplementation()
    }

}