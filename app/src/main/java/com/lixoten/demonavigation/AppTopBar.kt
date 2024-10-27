package com.lixoten.demonavigation

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun AppTopBar(
    currentScreen: AppDestinations,
    canNavigateBack: Boolean,
    navigateUpClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = currentScreen.title) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUpClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "stringResource(R.string.back_button)"
                    )
                }
            }
        }
    )
}