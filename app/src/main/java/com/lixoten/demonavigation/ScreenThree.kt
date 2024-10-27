package com.lixoten.demonavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lixoten.demonavigation.ui.theme.DemoNavigationTheme

@Composable
fun ScreenThree(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit
) {
    var numberOfPeople by remember { mutableStateOf(1) } // State untuk jumlah orang

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Teks input untuk jumlah orang
        Text(
            text = "Jumlah Orang:",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Tombol untuk mengurangi jumlah orang
            Button(onClick = { if (numberOfPeople > 1) numberOfPeople-- }) {
                Text(text = "-")
            }

            // Menampilkan jumlah orang
            Text(
                text = numberOfPeople.toString(),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Tombol untuk menambah jumlah orang
            Button(onClick = { numberOfPeople++ }) {
                Text(text = "+")
            }
        }

        // Tombol Cancel dan Next
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked
            ) {
                Text(text = "Cancel")
            }
            Button(
                onClick = onNextButtonClicked
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview
@Composable
fun ScreenThreePreview() {
    DemoNavigationTheme {
        ScreenThree(
            onNextButtonClicked = { },
            onCancelButtonClicked = { }
        )
    }
}
