package com.example.amphibians.ui.viewmodel

import com.example.amphibians.domain.model.Amphibian

sealed interface AmphibiansUiState {
    data class Success(val amphibianList: List<Amphibian>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}