package com.lixoten.demonavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ScreenLast(
    onCancelButtonClicked: () -> Unit // Parameter ini tidak akan digunakan lagi
) {
    // Hardcoded invoice details
    val selectedMovie = "Mencuri Raden Saleh"
    val selectedTime = "12:00"
    val numberOfPeople = 1
    val buyerName = "Nurul"
    val buyerEmail = "nurulafani03@gmail.com"
    val totalPrice = numberOfPeople * 50000 // Total price calculation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Menampilkan gambar di atas judul
        val transactionImage: Painter = painterResource(id = R.drawable.transaksi) // Ganti dengan ID gambar Anda
        Image(
            painter = transactionImage,
            contentDescription = "Transaksi",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Ubah ukuran sesuai kebutuhan
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Thank you for your booking!",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tampilkan detail faktur dengan rapi
        InvoiceDetail(label = "Movie", value = selectedMovie)
        InvoiceDetail(label = "Showtime", value = selectedTime)
        InvoiceDetail(label = "Number of People", value = numberOfPeople.toString())
        InvoiceDetail(label = "Buyer Name", value = buyerName)
        InvoiceDetail(label = "Buyer Email", value = buyerEmail)
        InvoiceDetail(label = "Total Price", value = "Rp. ${totalPrice.toString().replace("\\B(?=(\\d{3})+(?!\\d))".toRegex(), ".")}")

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun InvoiceDetail(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, modifier = Modifier.weight(1f))
        Text(text = value)
    }
}
