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
fun ScreenFour(
    onNextButtonClicked: (String, String) -> Unit, // Update function signature to take name and email
    onCancelButtonClicked: () -> Unit
) {
    var name by remember { mutableStateOf("") } // State untuk nama
    var email by remember { mutableStateOf("") } // State untuk email

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 16.dp) // Memberikan jarak bawah
        )

        // Input untuk Nama
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Input untuk Email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Tombol Cancel dan Next
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked
            ) {
                Text(text = "Cancel")
            }
            Button(
                onClick = {
                    onNextButtonClicked(name, email) // Pass name and email to the next function
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview
@Composable
fun ScreenFourPreview() {
    DemoNavigationTheme {
        ScreenFour(
            onNextButtonClicked = { _, _ -> },
            onCancelButtonClicked = { }
        )
    }
}
