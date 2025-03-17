package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Ex3_2() {
    var secretNumber by remember { mutableStateOf(Random.nextInt(0, 100)) }
    var numUser by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var intents by remember { mutableStateOf(0) }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Endevina el número secret")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = numUser,
            onValueChange = { numUser = it },
            label = { Text("Introdueix un número: ") },
            isError = isError
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val userGuess = numUser.toIntOrNull()
                if (userGuess != null) {
                    intents++
                    when {
                        userGuess < secretNumber -> {
                            message = "El número que busques és més gran"
                        }
                        userGuess > secretNumber -> {
                            message = "El número que busques és més petit"
                        }
                        else -> {
                            message = "Has encertat! Intents: $intents"
                            secretNumber = Random.nextInt(0, 100)
                            intents = 0
                        }
                    }
                    isError = false
                } else {
                    isError = true
                    message = "Si us plau, introdueix un número vàlid."
                }
            }
        ) {
            Text("Comprova")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (message.isNotEmpty()) {
            Text(text = message, color = if (message.contains("Has encertat")) Color.Green else Color.Red)
        }
    }
}