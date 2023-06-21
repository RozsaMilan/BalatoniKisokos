package com.example.szakdolgozat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children

class GameActivity : AppCompatActivity() {

    private val gameManager = GameManager()

    private lateinit var wordTextView: TextView
    private lateinit var felhasznaltBetukTV: TextView
    private lateinit var imageView: ImageView
    private lateinit var veresegTV: TextView
    private lateinit var gyozelemTV: TextView
    private lateinit var ujJatekBtn: Button
    private lateinit var lettersLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        imageView = findViewById(R.id.hangmanIV)
        wordTextView = findViewById(R.id.wordTextView)
        felhasznaltBetukTV = findViewById(R.id.lettersUsedTextView)
        veresegTV = findViewById(R.id.gameLostTextView)
        gyozelemTV = findViewById(R.id.gameWonTextView)
        ujJatekBtn = findViewById(R.id.newGameButton)
        lettersLayout = findViewById(R.id.lettersLayout)
        ujJatekBtn.setOnClickListener {
            ujJatekKezdes()
        }
        val gameState = gameManager.ujJatek()
        updateUI(gameState)

        lettersLayout.children.forEach { letterView ->
            if (letterView is TextView) {
                letterView.setOnClickListener {
                    val gameState = gameManager.jatek((letterView).text[0])
                    updateUI(gameState)
                    letterView.visibility = View.GONE
                }
            }
        }
    }

    private fun updateUI(gameState: GameState) {
        when (gameState) {
            is GameState.Lost -> vereseg(gameState.wordToGuess)
            is GameState.Running -> {
                wordTextView.text = gameState.underscoreWord
                felhasznaltBetukTV.text = "Felhasznált betűk: ${gameState.lettersUsed}"
                imageView.setImageDrawable(ContextCompat.getDrawable(this, gameState.drawable))
            }
            is GameState.Won -> gyozelem(gameState.wordToGuess)
        }
    }

    private fun vereseg(wordToGuess: String) {
        wordTextView.text = wordToGuess
        veresegTV.visibility = View.VISIBLE
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.halal))
        lettersLayout.visibility = View.GONE
    }

    private fun gyozelem(wordToGuess: String) {
        wordTextView.text = wordToGuess
        gyozelemTV.visibility = View.VISIBLE
        lettersLayout.visibility = View.GONE
    }

    private fun ujJatekKezdes() {
        veresegTV.visibility = View.GONE
        gyozelemTV.visibility = View.GONE
        val gameState = gameManager.ujJatek()
        lettersLayout.visibility = View.VISIBLE
        lettersLayout.children.forEach { letterView ->
            letterView.visibility = View.VISIBLE
        }
        updateUI(gameState)
    }
}