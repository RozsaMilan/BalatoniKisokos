package com.example.szakdolgozat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HalAdapter(private val halLista: ArrayList<Hal>, private val listener: OnItemClickListener) : RecyclerView.Adapter<HelyszinAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.container,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = helyszinLista[position]

        holder.nev.text = currentItem.Name


        val imageTarget = currentItem.Kep
        Picasso.get().load(imageTarget).into(holder.kep)
    }

    override fun getItemCount(): Int {
        return helyszinLista.size
    }

    inner class MyViewHolder(helyview: View) : RecyclerView.ViewHolder(helyview), View.OnClickListener{
        val nev: TextView = itemView.findViewById(R.id.tvHelyszinNev)
        val kep: ImageView = itemView.findViewById(R.id.ivHelyszinKep)

        init {
            helyview.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }


    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}