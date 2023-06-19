package com.mad4n7.maddiceroller.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mad4n7.maddiceroller.Dice

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(this)
                }
            }
        }
    }
}

@Composable
fun GreetingView(component: ComponentActivity = ComponentActivity()) {
    val diceSides = 6
    var diceImageId = remember { mutableStateOf(R.drawable.dice_3) }
    val dice = remember { Dice(diceSides) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 128.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = diceImageId.value),
            modifier = Modifier
                .width(128.dp),
            contentDescription = "A dice image"
        )
        Button(
            onClick = {
                diceImageId.value = getNewImageId(dice.roll())
                Toast.makeText(component, "Count: ${dice.rollsCount}", Toast.LENGTH_SHORT).show()
                if (dice.rollsCount > 3) {
                    Toast.makeText(component, "What are you doing?", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Roll")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView()
    }
}

fun getNewImageId(diceRoll: Int): Int {
    return when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}