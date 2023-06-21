package com.example.szakdolgozat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView

class Jatekok : AppCompatActivity() {

    private lateinit var quiz: CardView
    private lateinit var hangman: CardView
    private lateinit var wordle: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jatekok)

        quiz = findViewById(R.id.quizID)
        hangman = findViewById(R.id.hangmanID)
        wordle = findViewById(R.id.wordleID)

    }

    fun itemClicked(v: View){
        when(v.id){
            quiz.id -> {
                val intent = Intent(this, Quiz::class.java)
                startActivity(intent)
            }
            hangman.id -> {
                val intent = Intent(this, Hangman::class.java)
                startActivity(intent)
            }
            wordle.id -> {
                val intent = Intent(this, Wordle::class.java)
                startActivity(intent)
            }
            else -> Toast.makeText(this,"Valami nem jó", Toast.LENGTH_SHORT).show()
        }
    }

}