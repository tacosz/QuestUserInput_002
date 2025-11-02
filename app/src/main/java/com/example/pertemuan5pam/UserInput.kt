package com.example.pertemuan5pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import kotlin.collections.forEach
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistration (modifier: Modifier) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAsal by remember { mutableStateOf(value = "") }
    var textTgl by remember { mutableStateOf("") }
    var textRT by remember { mutableStateOf(value = "") }
    var textRW by remember { mutableStateOf(value = "") }
    var textUmur by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var check by remember { mutableStateOf(false) }

    var nama by remember { mutableStateOf(value = "") }
    var asal by remember { mutableStateOf(value = "") }
    var tgl by remember { mutableStateOf(value = "") }
    var rt by remember { mutableStateOf(value = "") }
    var rw by remember { mutableStateOf(value = "") }
    var umur by remember { mutableStateOf(value = "") }
    val datePickerState = rememberDatePickerState()
    var showSuccessDialog by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var jk by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    val image = painterResource(R.drawable.bg)

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = {showDatePicker = false},
            confirmButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                        datePickerState.selectedDateMillis?.let {
                            textTgl = convertMillisToDate(it)
                        }
                    }
                ) {
                    Text(text = "Pilih")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {showDatePicker = false}
                ) {
                    Text(text = "Batal")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = {showSuccessDialog = false},
            icon = {Icon(Icons.Default.Check, contentDescription = null)},
            title = {Text(text = "Berhasil")},
            text = {
                Column {
                    Text(text = "Nama: $nama")
                    Text(text = "Asal: $asal")
                    Text(text = "Tanggal Lahir: $tgl")
                    Text(text = "RT: $rt")
                    Text(text = "RW: $rw")
                    Text(text = "Umur: $umur")
                    Text(text = "Jenis Kelamin: $jk")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    showSuccessDialog = false
                }) {
                    Text("OK")
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
        ) {
            Text(
                text = stringResource(R.string.formregistration),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 15.dp, end = 15.dp),
                    label = { Text(text = "Nama Lengkap") },
                    onValueChange = {
                        textNama = it
                    }
                )

                OutlinedTextField(
                    value = textAsal,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    label = { Text(text = "Kota Asal") },
                    onValueChange = {
                        textAsal = it
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = textTgl,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { },
                        readOnly = true,
                        label = { Text(text = "Tanggal Lahir",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium) },
                        trailingIcon = {
                            IconButton(
                                onClick = { showDatePicker = true}
                            ) {
                                Icon(
                                    Icons.Default.DateRange, contentDescription = "Pilih Tanggal"
                                )
                            }
                        },
                        modifier = Modifier.width(160.dp)
                    )
                    OutlinedTextField(
                        value = textRT,
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .width(60.dp),
                        onValueChange = {
                            textRT = it
                        },
                        label = { Text(text = "RT") }
                    )
                    VerticalDivider(
                        thickness = dimensionResource(id = R.dimen.divider_tipis),
                        modifier = Modifier.padding().height(40.dp)
                    )
                    OutlinedTextField(
                        value = textRW,
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .width(60.dp),
                        onValueChange = {
                            textRW = it
                        },
                        label = {
                            Text(text = "RW",
                                fontSize = 14.sp)
                        }
                    )
                }
                OutlinedTextField(
                    value = textUmur,
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    label = { Text(text = "Umur",
                        fontSize = 14.sp)},
                    onValueChange = {
                        textUmur = it
                    }
                )
                Text(
                    stringResource(R.string.jk),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 24.dp, top = 12.dp),
                    fontWeight = FontWeight.Bold
                )
                Row {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier.padding(start = 12.dp).selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item
                                })
                            Text(text = item)
                        }
                    }
                }
                Row(modifier = Modifier.padding(start = 40.dp, end = 40.dp)) {
                    Checkbox(checked = check, onCheckedChange = { check = it })
                    Text(
                        stringResource(R.string.check),
                        fontSize = 15.sp,
                        color = Color.DarkGray
                    )
                }
                Spacer(Modifier.height(height = 80.dp).fillMaxWidth(1f))
                Button(
                    enabled = check && textNama.isNotEmpty() &&
                    textAsal.isNotEmpty() && textRT.isNotEmpty() &&
                    textRW.isNotEmpty() && textTgl.isNotEmpty(),
                    onClick = {
                        nama = textNama
                        asal = textAsal
                        tgl = textTgl
                        rt = textRT
                        rw = textRW
                        umur = textUmur
                        jk = textJK
                        showSuccessDialog = true
                    },
                    modifier = Modifier.width(width = 150.dp).align(Alignment.CenterHorizontally)
                ) {
                    Text(stringResource(R.string.submit))
                }
            }
        }
    }
}



