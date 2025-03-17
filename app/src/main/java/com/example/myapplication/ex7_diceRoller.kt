package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Ex7() {
    val context = LocalContext.current
    var dau1 by remember { mutableStateOf(1) }
    var dau2 by remember { mutableStateOf(1) }
    val dausImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )
    val dauNum = {
        dau1 = Random.nextInt(1, 7)
        dau2 = Random.nextInt(1, 7)
        if (dau1 == 6 && dau2 == 6) {
            Toast.makeText(context, "JACKPOT!", Toast.LENGTH_SHORT).show()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.tapestry),
            contentDescription = "fons",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.title,),
                contentDescription = "title",
                modifier = Modifier.size(400.dp)
            )
            Button(
                onClick = dauNum,
                modifier = Modifier.padding(15.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Roll the dice", fontSize = 20.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = dausImages[dau1 - 1]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { dau1 = Random.nextInt(1, 7) }
                )

                Image(
                    painter = painterResource(id = dausImages[dau2 - 1]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { dau2 = Random.nextInt(1, 7) }
                )

            }
        }
    }
}

