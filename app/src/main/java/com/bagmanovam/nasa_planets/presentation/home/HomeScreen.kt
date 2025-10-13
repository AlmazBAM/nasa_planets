package com.bagmanovam.nasa_planets.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bagmanovam.nasa_planets.core.presentation.SearchBar
import com.bagmanovam.nasa_planets.domain.model.SpaceObject
import com.bagmanovam.nasa_planets.presentation.home.state.HomeScreenState
import com.bagmanovam.nasa_planets.presentation.theme.Nasa_planetsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    onItemClick: (SpaceObject) -> Unit,
    onHomeAction: (HomeEvent) -> Unit,
) {
    Scaffold { innerPAdding ->
        Column(
            modifier = modifier
                .padding(innerPAdding)
                .fillMaxSize()
        ) {
            SearchBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                query = uiState.query,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrectEnabled = true,
                    showKeyboardOnFocus = true,
                    hintLocales = LocaleList(Locale("ru"))
                ),
                onQueryChange = { onHomeAction(HomeEvent.QueryChange(it)) }
            )
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 100.dp)) {
                items(uiState.spaceObjects) { spaceObject ->
                    AsyncImage(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop,
                        model = spaceObject.url,
                        contentDescription = "Item of the space objects"
                    )

                }
            }

        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    Nasa_planetsTheme {
        HomeScreen(
            uiState = HomeScreenState(),
            onHomeAction = {},
            onItemClick = {}
        )
    }
}