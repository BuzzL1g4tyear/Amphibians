package com.example.amphibians.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.domain.repository.AmphibiansRepository
import kotlinx.coroutines.launch
import java.io.IOException

class AmphibiansViewModel(
    private val retrofitRepository: AmphibiansRepository
) : ViewModel() {


    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            uiState = try {
                AmphibiansUiState
                    .Success(
                        retrofitRepository.getAmphibiansData()
                    )

            } catch (e: IOException) {
                AmphibiansUiState.Error
            }
        }
    }
}