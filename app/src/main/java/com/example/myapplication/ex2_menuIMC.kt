package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Ex2() {
    var nom: String by remember { mutableStateOf("") }
    var anyNaixement: String by remember { mutableStateOf(" ") }
    var alcada: String by remember { mutableStateOf(" ") }
    var pes: String by remember { mutableStateOf(" ") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var result: Double by remember { mutableStateOf(0.0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF64AD77), Color(0xB91DB218))
                )
            ),
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            TextField(
                value = nom,
                onValueChange = { nom = it },
                label = { Text("Enter your name") },
                modifier = Modifier.padding(13.dp)
            )
            TextField(
                value = anyNaixement,
                onValueChange = { anyNaixement = it },
                label = { Text("Enter your birthdate") },
                modifier = Modifier.padding(13.dp)
            )
            TextField(
                value = alcada,
                onValueChange = { alcada = it },
                label = { Text("Enter your high (meters)") },
                modifier = Modifier.padding(13.dp)

            )
            TextField(
                value = pes,
                onValueChange = { pes = it },
                label = { Text("Enter your weight") },
                modifier = Modifier.padding(13.dp)
            )
            Button(
                onClick = {
                    showText = true
                    result = pes.toDouble() / (alcada.toDouble() * alcada.toDouble())
                },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(20.dp)

            )
            {
                Text("Calculate IMC")
            }
            Spacer(Modifier.fillMaxHeight(0.1f))
            if (result < 18.5) {
                Text("You are underweight: $result")
            } else if (result > 18.5 && result < 24.9) {
                Text("You are fine :) ")
            } else {
                Text("Your are overweight: $result")
            }
        }
    }
}