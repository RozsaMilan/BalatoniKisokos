package com.example.szakdolgozat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView

class Allatok : AppCompatActivity() {

    private lateinit var eredei: CardView
    private lateinit var madarak: CardView
    private lateinit var halak: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allatok)

        eredei = findViewById(R.id.erdeiID)
        madarak = findViewById(R.id.madarakID)
        halak = findViewById(R.id.halakID)


    }

    fun itemClicked(v: View){
        when(v.id){
            eredei.id -> {
                val intent = Intent(this, Erdei::class.java)
                startActivity(intent)
            }
            madarak.id -> {
                val intent = Intent(this, Madarak::class.java)
                startActivity(intent)
            }
            halak.id -> {
                val intent = Intent(this, Halak::class.java)
                startActivity(intent)
            }
            else -> Toast.makeText(this,"Valami nem jó",Toast.LENGTH_SHORT).show()
        }
    }
}