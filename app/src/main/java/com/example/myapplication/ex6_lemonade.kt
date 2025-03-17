package com.example.myapplicationw

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import kotlin.random.Random

@Composable
fun Ex6() {
    var pasos by remember { mutableStateOf(1) }
    var numCliclsAleatori by remember { mutableStateOf(0) }
    var comptadorClicls by remember { mutableStateOf(0) }

    val img = when (pasos) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val text = when (pasos) {
        1 -> "Agafa una llimona"
        2 -> "Esprem la llimona"
        3 -> "Beu-te-la"
        else -> "Comença de nou"

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = img),
            contentDescription = "Lemonade",
            modifier = Modifier
                .clickable {
                    if (pasos == 1) {
                        pasos = 2
                        //hauries de pujar nota només pel fet que podria haver posat un rang de clics de 0 a 1000
                        //NOTA: quan facis el següent examen recorda't que els alumnes de vegades també ús fàcils les coses
                        numCliclsAleatori = Random.nextInt(2, 10)
                        comptadorClicls = 0
                    } else if (pasos == 2) {
                        comptadorClicls++
                        if (comptadorClicls >= numCliclsAleatori) {
                            pasos = 3
                        }
                    } else if (pasos == 3) {
                        pasos = 4
                    } else {
                        pasos = 1
                    }
                }
        )
        Text(text)
    }

}
