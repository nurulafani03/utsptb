package com.lixoten.demonavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lixoten.demonavigation.ui.theme.DemoNavigationTheme

@Composable
fun ScreenStart(
    onNextButtonClicked: () -> Unit
) {
    // State untuk mengelola pilihan film
    var selectedMovie by remember { mutableStateOf("Mencuri Raden Saleh") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Menampilkan logo CGV
        Image(
            painter = painterResource(id = R.drawable.logocgv), // Pastikan nama file gambar sesuai
            contentDescription = "Logo CGV",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(100.dp) // Sesuaikan ukuran logo sesuai kebutuhan
                .align(Alignment.CenterHorizontally) // Mengatur logo agar berada di tengah
        )

        // Judul di atas
        Text(
            text = "Welcome to CGV Padang",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
        )

        // Opsi pemilihan film
        Text(
            text = "Pilih Film:",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp, start = 16.dp)
        )

        // RadioButton untuk "Mencuri Raden Saleh"
        Row(modifier = Modifier.padding(start = 16.dp)) {
            RadioButton(
                selected = selectedMovie == "Mencuri Raden Saleh",
                onClick = { selectedMovie = "Mencuri Raden Saleh" }
            )
            Text(text = "Mencuri Raden Saleh", modifier = Modifier.padding(start = 8.dp))
        }

        // RadioButton untuk "5 cm"
        Row(modifier = Modifier.padding(start = 16.dp)) {
            RadioButton(
                selected = selectedMovie == "5 cm",
                onClick = { selectedMovie = "5 cm" }
            )
            Text(text = "5 cm", modifier = Modifier.padding(start = 8.dp))
        }

        // RadioButton untuk "Ancika"
        Row(modifier = Modifier.padding(start = 16.dp)) {
            RadioButton(
                selected = selectedMovie == "Ancika",
                onClick = { selectedMovie = "Ancika" }
            )
            Text(text = "Ancika", modifier = Modifier.padding(start = 8.dp))
        }

        // Tombol "Next" di tengah
        Button(
            onClick = onNextButtonClicked,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    DemoNavigationTheme {
        ScreenStart(
            onNextButtonClicked = { }
        )
    }
}