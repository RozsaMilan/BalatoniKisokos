package com.example.szakdolgozat

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.squareup.picasso.Picasso

class Erdei : AppCompatActivity(), ErdoAdapter.OnItemClickListener  {

    private lateinit var rv: RecyclerView
    private lateinit var erdeiLista: ArrayList<Erdo>
    private lateinit var adapter: ErdoAdapter
    private lateinit var db: FirebaseFirestore

    private lateinit var myDialog: Dialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erdei)

        rv = findViewById(R.id.erdeilista)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        erdeiLista = arrayListOf()

        adapter = ErdoAdapter(erdeiLista,this)

        rv.adapter = adapter

        eventChangeListener()

        myDialog = Dialog(this)
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Erdei").orderBy("Name", Query.Direction.ASCENDING).addSnapshotListener(object :
            EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error!=null){
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!){
                    if (dc.type== DocumentChange.Type.ADDED){
                        erdeiLista.add(dc.document.toObject(Erdo::class.java))
                    }
                }
                adapter.notifyDataSetChanged()
            }

        })

    }

    override fun onItemClick(position: Int) {
        val clickedItem: Erdo = erdeiLista[position]
        showPopUp(clickedItem)
    }

    fun showPopUp(clickedItem: Erdo) {

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