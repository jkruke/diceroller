package de.jkrukenberg.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        // Roll all dices when the roll button is clicked
        rollButton.setOnClickListener {
            for (diceId in listOf(R.id.dice1, R.id.dice2)) {
                rollDice(diceId)
            }
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(diceId: Int) {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(diceId)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    /**
     * Roll the dice and return a random result
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
