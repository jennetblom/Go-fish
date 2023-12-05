package com.example.gofish

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val context: Context,
                  var handCards: MutableList<Card>,
                  val cardClickListener: CardClickListener,
                  val isClickable: Boolean

):
RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.card_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return handCards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = handCards[position]

        Log.d("CardAdapter", "Binding card at position $position. Card: $card")

        if(card.isFaceUp){
            holder.cardImage.setImageResource(card.faceUpImage)
        }
        else{
            holder.cardImage.setImageResource(card.faceDownImage)
        }

        if(isClickable) {
            holder.cardImage.setOnClickListener {
                cardClickListener.onCardClick(card)

                //position, card.value
            }
        }
    }

    fun removeItem(position: Int): Card {
        val removedCard = handCards.removeAt(position)
        notifyItemRemoved(position)
        return removedCard
    }

    fun addItem(card: Card, position: Int = handCards.size) {
        handCards.add(position, card)
        notifyItemInserted(position)
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardImage: ImageView = itemView.findViewById<ImageView>(R.id.cardImage)

    }
    }
