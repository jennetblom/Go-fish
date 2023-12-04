package com.example.gofish

import android.animation.ObjectAnimator
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class CardTransferAnimator : DefaultItemAnimator() {
    override fun animateChange(
        oldHolder:RecyclerView.ViewHolder?,
        newHolder:RecyclerView.ViewHolder?,
        fromX:Int,
        fromY:Int,
        toX:Int,
        toY:Int

    ):Boolean{
        if(oldHolder!=null && newHolder!=null){
            val animation = ObjectAnimator.ofFloat(
                newHolder.itemView, "translationY",fromX.toFloat(),toY.toFloat()
            )
            animation.duration = 1000
            animation.start()
        }
        return super.animateChange(oldHolder, newHolder, fromX, fromY, toX, toY)
    }



}