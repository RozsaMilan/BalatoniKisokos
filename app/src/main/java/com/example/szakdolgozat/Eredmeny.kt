package com.example.szakdolgozat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Eredmeny : AppCompatActivity() {
    private var finishBtn: Button? = null
    private var pointsText: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eredmeny)

        val bundle: Bundle? = intent.extras
        val points: String? = intent.getStringExtra("points")

        finishBtn = findViewById(R.id.btn_finish)
        pointsText = findViewById(R.id.tv_score)

        pointsText?.text = "${points} pontot értél el a Quizben!"

        finishBtn?.setOnClickListener {
            val intent = Intent(this,Jatekok::class.java)
            startActivity(intent)
        }

    }
}