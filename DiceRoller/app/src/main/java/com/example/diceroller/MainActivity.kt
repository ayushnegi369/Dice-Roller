package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
//  lateint is used to create a promise that the var will be initialized later
//   by this we need not to assign null value to any variable even before it's created
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.roll_button)
//       rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
//           to create a pop up notification on the screen when button is clicked !
//           Toast.makeText(this, "Button is clicked !", Toast.LENGTH_SHORT).show()
//           calling the roll dice function
            rollDice()
        }
//      initializing the diceImage var for only omnce
        diceImage = findViewById(R.id.dice_image)
    }
//  roll dice function logic
    private fun rollDice() {
//       val resultText : TextView = findViewById(R.id.result_text)
//      generating random number
//      adding one to make the range between 1 to 6
//      else range will be 0 to 5
//       resultText.text = random_number.toString()
        val randomNumber : Int = Random().nextInt(6) + 1
        val drawableResource = when(randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//       this method is not memory efficient
//       it re-renders the diceImage var again and again
//       val diceImage : ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
        Toast.makeText(this, randomNumber.toString(), Toast.LENGTH_SHORT).show()
    }
}