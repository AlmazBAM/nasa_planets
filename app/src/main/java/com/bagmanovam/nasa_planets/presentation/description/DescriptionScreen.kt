package com.bagmanovam.nasa_planets.presentation.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bagmanovam.nasa_planets.presentation.description.state.DescriptionState
import com.bagmanovam.nasa_planets.presentation.theme.Nasa_planetsTheme

@Composable
fun DescriptionScreen(
    modifier: Modifier = Modifier,
    uiState: DescriptionState,
) {
    Scaffold { innerPaddings ->
        Column(
            modifier = modifier.padding(innerPaddings),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                model = uiState.imageUrl,
                contentDescription = "Item of the space objects"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 24.sp,
                    lineHeight = 24.sp
                ),
                text = uiState.title,
            )
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

@Preview
@Composable
private fun DescriptionScreenPreview() {
    Nasa_planetsTheme {
        DescriptionScreen(
            uiState = DescriptionState()
        )
    }
}