package com.example.gofish

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class gameAnimations {

    fun seaCardAnimations(view : View){

        val moveUpAnimator = ObjectAnimator.ofFloat(view, "translationY", -100f, 0f)
        moveUpAnimator.duration = 1000
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", -0f, -50f)
        moveDownAnimator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(moveUpAnimator, moveDownAnimator)
        animatorSet.start()
    }

}

