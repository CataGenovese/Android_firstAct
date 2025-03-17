package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Ex5() {
    //conversió
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    //num usuari
    var textUser by remember { mutableStateOf(" ") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf(" ") }
    val convertions = listOf(
        "De polzada a centímetre",
        "De iarda a metre",
        "De milla a quilòmetre",
        "De centímetre a polzada",
        "De metre a iarda",
        "De quilòmetre a milla"
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Factor de conversió", fontWeight = FontWeight.Bold, fontSize = 24.sp,
        )

        TextField(
            value = textUser,
            onValueChange = { textUser = it },
            label = { Text("Enter a number") }
        )

        OutlinedTextField(
            value = selectedText,
            onValueChange = { },
            readOnly = true,
            enabled = false,
            label = { Text("Select a conversion") },
            modifier = Modifier
                .clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            convertions.forEach { hobby ->
                DropdownMenuItem(
                    text = { Text(text = hobby) },
                    onClick = {
                        selectedText = hobby
                        expanded = false
                    }
                )
            }
        }
        Button(
            onClick = {
                showText = true
                val inputNum = try {
                    textUser.toDouble()
                } catch (e: NumberFormatException) {
                    0.0
                }
                result = menu(inputNum, selectedText).toString()
//       :)         println("CATAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA $result")
            }
        )
        {
            Text("Convertir")
        }
        if (showText) {
            Text("Resultat: $result")
        }
    }
}


fun menu(num: Double, string: String): Double {
    val result = when (string) {
        "De polzada a centímetre" -> polzadaACentimetre(num)
        "De iarda a metre" ->  iardaAMetre(num)
        "De milla a quilòmetre" -> millaAQuilometre(num)
        "De centímetre a polzada" -> centimetreAPolzada(num)
        "De metre a iarda" ->  metreAIarda(num)
        "De quilòmetre a milla" -> quilometreAMilla(num)
        else -> 0.0

    }
    return result
}

fun polzadaACentimetre(num: Double): Double {
    return num * 2.54
}

fun iardaAMetre(num: Double): Double {
    return num * 0.9144
}

fun millaAQuilometre(num: Double): Double {
    return num * 1.60934
}

fun centimetreAPolzada(num: Double): Double {
    return num / 2.54
}

fun metreAIarda(num: Double): Double {
    return (num / 0.9144)
}

fun quilometreAMilla(num: Double): Double {
    return num / 1.60934
}

@Preview(showBackground = true)
@Composable
fun Ex() {
    MyApplicationTheme {
        Ex5()
    }
}
