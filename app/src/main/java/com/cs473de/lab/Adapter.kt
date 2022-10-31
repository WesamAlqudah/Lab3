package com.cs473de.lab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter: RecyclerView.Adapter<Adapter.VH>() {
    private var itemsList:ArrayList<Item>?= ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.VH {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: Adapter.VH, position: Int) {
        itemsList.let {
            if (it?.size!! >0){
                val item= it[position]
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsList.let {
            it!!.size
        }?:0
    }

    fun setList(list: ArrayList<Item>){
        this.itemsList=list
        notifyDataSetChanged()
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.img_item)
        val title:TextView = itemView.findViewById(R.id.title_item)
        fun bind(item: Item){
            image.setImageResource(item.image!!)
            title.text=item.name
        }
    }
}