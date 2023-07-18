package com.example.amphibians.ui.di

import com.example.amphibians.ui.viewmodel.AmphibiansViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        AmphibiansViewModel(
            retrofitRepository = get()
        )
    }
}