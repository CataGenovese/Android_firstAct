package com.example.myapplication

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun Ex1() {
    var preuMenu: String by remember { mutableStateOf("") }
    var percentatge: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var result: Double by remember { mutableStateOf(0.0) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = preuMenu, onValueChange = { preuMenu = it }, label = { Text("Enter a price") }
        )
        TextField(
            value = percentatge,
            onValueChange = { percentatge = it },
            label = { Text("Enter a percentage") }
        )

        Button(
            onClick = {
                showText = true
                result = (preuMenu.toDouble() * percentatge.toDouble()) / 100 + preuMenu.toDouble()
            }

        )
        {
            Text("Calculate")
        }
        Spacer(Modifier.fillMaxHeight(0.1f))
        if(showText) {
            Text("Result: $result")
        }
    }


}