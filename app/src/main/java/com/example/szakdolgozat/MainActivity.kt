package com.example.szakdolgozat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var allatok: CardView
    private lateinit var helyszinek: CardView
    private lateinit var jatekok: CardView
    private lateinit var tortenet: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allatok = findViewById(R.id.allatokID)
        helyszinek = findViewById(R.id.helyszinID)
        jatekok = findViewById(R.id.jatekID)
        tortenet = findViewById(R.id.tortenetID)

    }

    fun itemClicked(v: View){
        when(v.id){
            allatok.id -> {
                val intent = Intent(this, Allatok::class.java)
                startActivity(intent)
            }
            helyszinek.id -> {
                val intent = Intent(this, HelyszinekLista::class.java)
                startActivity(intent)
            }
            jatekok.id -> {
                val intent = Intent(this, Jatekok::class.java)
                startActivity(intent)
            }
            tortenet.id -> {
                val intent = Intent(this, Tortenet::class.java)
                startActivity(intent)
            }
        }
    }
}