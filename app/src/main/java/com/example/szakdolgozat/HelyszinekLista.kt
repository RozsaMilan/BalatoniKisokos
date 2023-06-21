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

class HelyszinekLista : AppCompatActivity(), HelyszinAdapter.OnItemClickListener {

    private lateinit var rv: RecyclerView
    private lateinit var helyszinLista: ArrayList<Helyszin>
    private lateinit var adapter: HelyszinAdapter
    private lateinit var db: FirebaseFirestore

    private lateinit var myDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helyszinek_lista)


        rv = findViewById(R.id.helyszineklista)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        helyszinLista = arrayListOf()

        adapter = HelyszinAdapter(helyszinLista,this)

        rv.adapter = adapter

        eventChangeListener()

        myDialog = Dialog(this)
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Helyszinek").orderBy("Name",Query.Direction.ASCENDING).addSnapshotListener(object :EventListener<QuerySnapshot>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error!=null){
                   return
                }

                for (dc: DocumentChange in value?.documentChanges!!){
                    if (dc.type==DocumentChange.Type.ADDED){
                        helyszinLista.add(dc.document.toObject(Helyszin::class.java))
                    }
                }
                adapter.notifyDataSetChanged()
            }

        })



    }

    override fun onItemClick(position: Int) {
        val clickedItem: Helyszin = helyszinLista[position]
        showPopUp(clickedItem)
    }

    @SuppressLint("CutPasteId")
    fun showPopUp(clickedItem: Helyszin) {

        val szel = clickedItem.Szelesseg
        val hossz = clickedItem.Hosszusag

        myDialog.setContentView(R.layout.helyszinpopuplayout)
        val popUpClose: TextView = myDialog.findViewById(R.id.popUpClose)
        val googleMapsID: Button = myDialog.findViewById(R.id.googleMapsID)
        val ivID: ImageView = myDialog.findViewById(R.id.ivID)
        val nameID: TextView = myDialog.findViewById(R.id.nevID)
        val descriptionID: TextView = myDialog.findViewById(R.id.descriptionID)

        val imageTarget = clickedItem.Kep
        Picasso.get().load(imageTarget).into(ivID)
        nameID.text = clickedItem.Name
        descriptionID.text = clickedItem.Leiras
        descriptionID.movementMethod = ScrollingMovementMethod()

        popUpClose.setOnClickListener { myDialog.dismiss() }
        googleMapsID.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=$szel,$hossz&mode=d"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        myDialog.show()

    }


}
