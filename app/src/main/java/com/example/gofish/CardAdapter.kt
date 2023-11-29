package com.example.gofish

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val context: Context,  val carddeck: List<Card>):
RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.card_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return carddeck.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = carddeck[position]

        if(card.isFaceUp){
            holder.cardImage.setImageResource(card.faceUpImage)
        }
        else{
            holder.cardImage.setImageResource(card.faceDownImage)
        }
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cardImage:ImageView = itemView.findViewById<ImageView>(R.id.cardImage)
    }
}