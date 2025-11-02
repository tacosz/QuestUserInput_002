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
import android.icu.util.Calendar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import kotlin.collections.forEach

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistration (modifier: Modifier)
{
    var textNama by remember { mutableStateOf(value = "") }
    var textAsal by remember { mutableStateOf(value = "") }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = it
        "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH) + 1}/${calendar.get(Calendar.YEAR)}"
    } ?: ""

    var textRT by remember { mutableStateOf(value = "") }
    var textRW by remember { mutableStateOf(value = "") }
    var textUmur by remember { mutableStateOf(value = "") }
    var showNumberPicker by remember { mutableStateOf(false) }
    var textJK by remember { mutableStateOf(value = "") }
    var check by remember { mutableStateOf(false) }

    var nama by remember { mutableStateOf(value = "") }
    var asal by remember { mutableStateOf(value = "") }
    var tgl by remember { mutableStateOf(value = "") }
    var rt by remember { mutableStateOf(value = "") }
    var rw by remember { mutableStateOf(value = "") }
    var umur by remember { mutableStateOf(value = "") }
    var submitted by remember { mutableStateOf(false) }

    val gender: List<String> = listOf("Laki-laki","Perempuan")

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
        ) {
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp),
                label = {Text(text = "Nama Lengkap")},
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
                label = {Text(text = "Kota Asal")},
                onValueChange = {
                    textAsal = it
                }
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = selectedDate,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    onValueChange = { },
                    readOnly = true,
                    label = {Text(text = "Tanggal Lahir")},
                    trailingIcon = {
                        IconButton(
                            onClick = {showDatePicker = !showDatePicker}
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Select Date"
                            )
                        }
                    },
                    modifier = Modifier.weight(1f)
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clickable(enabled = true, onClick = {showDatePicker = true})
                )
                OutlinedTextField(
                    value = textRT,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .width(60.dp)
                        .padding(top = 12.dp),
                    onValueChange = {
                        textRT = it
                    },
                    label = {Text(text = "RT")}
                )
                VerticalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_tipis),
                    modifier = Modifier.padding(top = 30.dp).height(40.dp)
                )
                OutlinedTextField(
                    value = textRW,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .width(60.dp)
                        .padding(top = 12.dp),
                    onValueChange = {
                        textRW = it
                    },
                    label = {Text(text = "RW")
                    }
                )
            }
            OutlinedTextField(
                value = textUmur,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                label = {Text(text = "Umur")},
                onValueChange = {
                    textUmur = it
                }
            )
            Text(stringResource(R.string.jk),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp, top = 12.dp),
                fontWeight = FontWeight.Bold
            )
            Row {
                gender.forEach { item ->
                    Row(modifier = Modifier.padding(start = 12.dp).selectable(
                        selected = textJK == item,
                        onClick = {textJK = item}
                    ), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            })
                        Text(text = item)
                    }
                }
            }
            Row (modifier = Modifier.padding(start = 40.dp, end = 40.dp)) {
                Checkbox(checked = check, onCheckedChange = {check = it})
                Text(stringResource(R.string.check),
                    fontSize = 15.sp,
                    color = Color.DarkGray)
            }
            Spacer(Modifier.height(height = 50.dp))
        }
    }
}