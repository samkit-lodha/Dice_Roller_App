package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollDice : Button = findViewById(R.id.roll_button)
        rollDice.setOnClickListener({ rollDice() })
        diceImage1=findViewById(R.id.dice_view1)
        diceImage2=findViewById(R.id.dice_view2)
    }

    private fun rollDice(){

        Toast.makeText(this,"Both dice are rolling...",Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            val randomInt1 : Int =(1..6).random()
            var randomInt2 : Int = randomInt1

            while(randomInt1==randomInt2){
                randomInt2 = (1..6).random()
            }

            var drawableResource = when(randomInt1){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6
            }

            diceImage1.setImageResource(drawableResource)

            drawableResource = when(randomInt2){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6
            }

            diceImage2.setImageResource(drawableResource)

        },2000)

    }
}