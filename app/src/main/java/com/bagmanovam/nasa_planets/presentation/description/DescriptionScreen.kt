package com.bagmanovam.nasa_planets.presentation.description

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bagmanovam.nasa_planets.presentation.description.state.DescriptionState
import com.bagmanovam.nasa_planets.presentation.theme.Nasa_planetsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionScreen(
    modifier: Modifier = Modifier,
    uiState: DescriptionState,
    isMainScreen: Boolean,
    onBackClick: () -> Unit,
) {
    Log.e("TAG", "DescriptionScreen: $isMainScreen", )
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            if (!isMainScreen) {
                CenterAlignedTopAppBar(
                    title = {},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                onBackClick()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBackIosNew,
                                contentDescription = "Back button"
                            )
                        }
                    }
                )
            }
        }
    ) { innerPaddings ->
        LazyColumn (
            modifier = modifier
                .padding(innerPaddings)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                    model = uiState.imageUrl,
                    contentDescription = "Item of the space objects"
                )
            }

            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 24.sp,
                        lineHeight = 24.sp
                    ),
                    text = uiState.title,
                )
            }
            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 16.sp,
                        lineHeight = 16.sp
                    ),
                    text = uiState.description,
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DescriptionScreenPreview() {
    Nasa_planetsTheme {
        DescriptionScreen(
            uiState = DescriptionState(),
            isMainScreen = false,
            onBackClick = {}
        )
    }
}