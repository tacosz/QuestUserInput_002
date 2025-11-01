package com.example.pertemuan5pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormRegistration (modifier: Modifier)
{
    var textNama by remember { mutableStateOf(value = "") }
    var textAsal by remember { mutableStateOf(value = "") }
    var textTgl by remember { mutableStateOf(value = "") }
    var textRT by remember { mutableStateOf(value = "") }
    var textRW by remember { mutableStateOf(value = "") }
    var textUmur by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }

    var nama by remember { mutableStateOf(value = "") }
    var asal by remember { mutableStateOf(value = "") }
    var tgl by remember { mutableStateOf(value = "") }
    var rt by remember { mutableStateOf(value = "") }
    var rw by remember { mutableStateOf(value = "") }
    var umur by remember { mutableStateOf(value = "") }

    val gender by remember { mutableStateOf(value = "") }

    val image = painterResource(R.drawable.bg)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, start = 40.dp, end = 40.dp, bottom = 30.dp)
    ) {
        Text(
            text = stringResource(R.string.formregistration),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Card(
            modifier = Modifier.fillMaxSize()
        ) {  }
    }
}