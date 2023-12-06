package com.example.gofish

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val oceanImage1 = findViewById<ImageView>(R.id.oceanImage1)
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        val cardGameTextView = findViewById<TextView>(R.id.cardGameTextView)
        val fishImage = findViewById<ImageView>(R.id.fishImage)
        val howButton = findViewById<Button>(R.id.howButton)
        val playButton = findViewById<Button>(R.id.playButton)


        playButton.setOnClickListener {
            val intent =  Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        howButton.setOnClickListener {
            val intent = Intent(this,RulesActivity::class.java)
            startActivity(intent)
        }

        fishImage.setOnClickListener {
            val moveDownAnimator = ObjectAnimator.ofFloat(fishImage, "translationY", -0f, 700f)
            moveDownAnimator.duration = 2000
            val moveUpAnimator = ObjectAnimator.ofFloat(fishImage, "translationY", 500f, 300f)
            moveUpAnimator.duration = 1000
            val moveLeftAnimator = ObjectAnimator.ofFloat(fishImage, "translationX", 0f,-400f)
            moveLeftAnimator.duration=1000
            val bigXAnimator= ObjectAnimator.ofFloat(fishImage,"scaleX",1.0f,3.0f)
            val bigYAnimator= ObjectAnimator.ofFloat(fishImage,"scaleY",1.0f,3.0f)
            bigXAnimator.duration=2000
            bigYAnimator.duration=2000
            val animatorSet = AnimatorSet()
            val animatorSet2 = AnimatorSet()
            fishImage.setImageResource(R.drawable.redfish2)
            animatorSet.playTogether(moveDownAnimator,moveUpAnimator,moveLeftAnimator,moveUpAnimator)
            animatorSet2.playTogether(bigXAnimator,bigYAnimator)
            animatorSet.start()
            animatorSet2.start()
        }


    }


}