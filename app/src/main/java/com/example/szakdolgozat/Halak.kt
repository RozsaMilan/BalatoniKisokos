package com.example.szakdolgozat

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.*
import com.squareup.picasso.Picasso

class Halak : AppCompatActivity(), HalAdapter.OnItemClickListener {

    private lateinit var rv: RecyclerView
    private lateinit var halakLista: ArrayList<Hal>
    private lateinit var adapter: HalAdapter
    private lateinit var db: FirebaseFirestore

    private lateinit var myDialog: Dialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halak)

        rv = findViewById(R.id.halaklista)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        halakLista = arrayListOf()

        adapter = HalAdapter(halakLista,this)

        rv.adapter = adapter

        eventChangeListener()

        myDialog = Dialog(this)


    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Halak").orderBy("Name", Query.Direction.ASCENDING).addSnapshotListener(object :
            EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error!=null){
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!){
                    if (dc.type== DocumentChange.Type.ADDED){
                        halakLista.add(dc.document.toObject(Hal::class.java))
                    }
                }
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onItemClick(position: Int) {
        val clickedItem: Hal = halakLista[position]
        showPopUp(clickedItem)
    }

    fun showPopUp(clickedItem: Hal) {

        myDialog.setContentView(R.layout.allatpopuplayout)
        val popUpClose: TextView = myDialog.findViewById(R.id.popUpClose)
        val videoID: Button = myDialog.findViewById(R.id.videoID)
        val ivID: ImageView = myDialog.findViewById(R.id.ivID)
        val nameID: TextView = myDialog.findViewById(R.id.nevID)
        val descriptionID: TextView = myDialog.findViewById(R.id.descriptionID)

        val imageTarget = clickedItem.Kep
        Picasso.get().load(imageTarget).into(ivID)
        nameID.text = clickedItem.Name
        descriptionID.text = clickedItem.Leiras
        descriptionID.movementMethod = ScrollingMovementMethod()

        popUpClose.setOnClickListener { myDialog.dismiss() }
        videoID.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse(clickedItem.Video))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)
        }

        myDialog.show()

    }
}