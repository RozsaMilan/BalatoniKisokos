package com.example.szakdolgozat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HalAdapter(private val halLista: ArrayList<Hal>, private val listener: OnItemClickListener) : RecyclerView.Adapter<HalAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HalAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.container,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = halLista[position]

        holder.nev.text = currentItem.Name


        val imageTarget = currentItem.Kep
        Picasso.get().load(imageTarget).into(holder.kep)
    }

    override fun getItemCount(): Int {
        return halLista.size
    }

    inner class MyViewHolder(halview: View) : RecyclerView.ViewHolder(halview), View.OnClickListener{
        val nev: TextView = itemView.findViewById(R.id.tvContainer)
        val kep: ImageView = itemView.findViewById(R.id.ivContainer)

        init {
            halview.setOnClickListener(this)
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