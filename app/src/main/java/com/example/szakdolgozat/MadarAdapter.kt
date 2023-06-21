package com.example.szakdolgozat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MadarAdapter(private val madarLista: ArrayList<Madar>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MadarAdapter.MyViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MadarAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.container,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = madarLista[position]

        holder.nev.text = currentItem.Name


        val imageTarget = currentItem.Kep
        Picasso.get().load(imageTarget).into(holder.kep)
    }

    override fun getItemCount(): Int {
        return madarLista.size
    }

    inner class MyViewHolder(madarview: View) : RecyclerView.ViewHolder(madarview), View.OnClickListener{
        val nev: TextView = itemView.findViewById(R.id.tvContainer)
        val kep: ImageView = itemView.findViewById(R.id.ivContainer)

        init {
            madarview.setOnClickListener(this)
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