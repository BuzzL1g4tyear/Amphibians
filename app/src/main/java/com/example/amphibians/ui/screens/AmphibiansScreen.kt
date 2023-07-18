package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.domain.model.Amphibian
import com.example.amphibians.ui.viewmodel.AmphibiansUiState
import com.example.amphibians.ui.viewmodel.AmphibiansViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp(
    amphibiansViewModel: AmphibiansViewModel = koinViewModel()
) {
    Scaffold(
        topBar = {
            AmphibiansTopBar()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
        ) {

            when (amphibiansViewModel.uiState) {

                is AmphibiansUiState.Success -> {
                    AmphibiansGrid(
                        amphibianList = (amphibiansViewModel.uiState as
                                AmphibiansUiState.Success).amphibianList
                    )
                }

                else -> {

                }
            }
        }
    }
}

@Composable
fun AmphibiansTopBar() {

}

@Composable
fun AmphibiansGrid(
    amphibianList: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = PaddingValues(4.dp)
    ) {
        items(amphibianList, key = { amphibian -> amphibian.name }) { amphibian ->
            AmphibiansCard(amphibian = amphibian)
        }
    }
}

@Composable
fun AmphibiansCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
    ) {
        Column {
            Text(text = amphibian.name)
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = "Frog"
            )
            Text(text = amphibian.description)
        }
    }
}

@Preview
@Composable
fun AmPrev() {
    AmphibiansApp()
}