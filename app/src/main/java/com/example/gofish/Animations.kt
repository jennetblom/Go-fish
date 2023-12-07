package com.example.gofish

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.media.Image
import android.view.View
import android.widget.ImageView

class Animations {

    fun seaCardAnimations(view : View){

        val moveUpAnimator = ObjectAnimator.ofFloat(view, "translationY", -100f, 0f)
        moveUpAnimator.duration = 1000
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", -0f, -50f)
        moveDownAnimator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(moveUpAnimator, moveDownAnimator)
        animatorSet.start()
    }
    fun fishAnimation(view : ImageView){

        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", -0f, 700f)
        moveDownAnimator.duration = 2000
        val moveUpAnimator = ObjectAnimator.ofFloat(view, "translationY", 500f, 300f)
        moveUpAnimator.duration = 1000
        val moveLeftAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f,-400f)
        moveLeftAnimator.duration=1000
        val bigXAnimator= ObjectAnimator.ofFloat(view,"scaleX",1.0f,3.0f)
        val bigYAnimator= ObjectAnimator.ofFloat(view,"scaleY",1.0f,3.0f)
        bigXAnimator.duration=2000
        bigYAnimator.duration=2000
        val animatorSet = AnimatorSet()
        val animatorSet2 = AnimatorSet()
        view.setImageResource(R.drawable.redfish2)
        animatorSet.playTogether(moveDownAnimator,moveUpAnimator,moveLeftAnimator,moveUpAnimator)
        animatorSet2.playTogether(bigXAnimator,bigYAnimator)
        animatorSet.start()
        animatorSet2.start()
    }
    fun cardFromSeaHuman(view : ImageView){
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", 200f, 900f)
        val moveRightAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 350f)
        moveDownAnimator.duration = 1500
        val animatorSet = AnimatorSet()
        moveRightAnimator.duration = 1000
        animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
        animatorSet.start()
    }
    fun cardFromSeaComputer(view : ImageView){
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", 400f, -100f)
        val moveRightAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 350f)
        moveDownAnimator.duration = 1500
        val animatorSet = AnimatorSet()
        moveRightAnimator.duration = 1000
        animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
        animatorSet.start()
    }
    fun givenCardHuman(view : ImageView){
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", -0f, 800f)
        val moveRightAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 350f)
        moveDownAnimator.duration = 1000
        val animatorSet = AnimatorSet()
        moveRightAnimator.duration = 1000
        animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
        animatorSet.start()
    }
    fun givenCardComputer(view:ImageView){
        val moveUpAnimator = ObjectAnimator.ofFloat(view, "translationY", 800f, 0f)
        moveUpAnimator.duration = 1000
        val moveRightAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 350f)
        moveRightAnimator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(moveUpAnimator, moveRightAnimator)
        animatorSet.start()
    }
    fun goFish(view:ImageView){
        val moveUpAnimator = ObjectAnimator.ofFloat(view, "translationY", -100f, 0f)
        moveUpAnimator.duration = 500
        val moveDownAnimator = ObjectAnimator.ofFloat(view, "translationY", -0f, -50f)
        moveDownAnimator.duration = 500
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(moveUpAnimator, moveDownAnimator)
        animatorSet.start()
    }
}

