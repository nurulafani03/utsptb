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
fun ScreenTwo(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit
) {
    var selectedTime by remember { mutableStateOf("12.00") } // State untuk pilihan jam

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Schedule CGV",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Pilihan Jam
        Text(
            text = "Pilih Jam:",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedTime == "12.00",
                    onClick = { selectedTime = "12.00" }
                )
                Text(text = "12.00", modifier = Modifier.padding(start = 8.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedTime == "15.00",
                    onClick = { selectedTime = "15.00" }
                )
                Text(text = "15.00", modifier = Modifier.padding(start = 8.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedTime == "19.00",
                    onClick = { selectedTime = "19.00" }
                )
                Text(text = "19.00", modifier = Modifier.padding(start = 8.dp))
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
fun ScreenTwoPreview() {
    DemoNavigationTheme {
        ScreenTwo(
            onNextButtonClicked = { },
            onCancelButtonClicked = { }
        )
    }
}
