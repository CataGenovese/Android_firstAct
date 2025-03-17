package com.example.myapplication

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Ex3() {
    var num by remember { mutableStateOf(Random.nextInt(0, 100).toString()) }
    var numUser by remember { mutableStateOf(" ") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = ("Onichan t(s)extoooo")
        )
        TextField(
            value = numUser,
            onValueChange = { numUser = it },
            label = { Text("Enter a number: ") },
            isError= isError
        )
        Button(
            onClick = {
                showText = true
                isError= numUser!=num
            }
        )
        {
            Text("Check")
        }
        if (showText) {
            if (numUser == num) {
                Text("You got a right number: $num!",
                    color=Color.Green)
            } else {
                Text("Your number is wrong, try again!", color= Color.Red)

            }
        }
    }
}


