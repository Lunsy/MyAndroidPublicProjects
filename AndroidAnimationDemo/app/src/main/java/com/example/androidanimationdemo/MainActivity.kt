package com.example.androidanimationdemo

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.animationImageView)
        imageView.setOnClickListener {
            openScaleActivity()
        }


        val gradientOverlay = findViewById<LinearLayout>(R.id.gradient_overlay)

        val background = imageView.background as AnimationDrawable
        background.setEnterFadeDuration(3000)
        background.setExitFadeDuration(1000)
        background.start()

        val overlay = gradientOverlay.background as AnimationDrawable
        overlay.setEnterFadeDuration(3000)
        overlay.setExitFadeDuration(1000)
        overlay.start()

//        Timer("My Timer", false).
//        schedule(10000)
//        {
//            openScaleActivity()
//        }

        Handler().postDelayed({
            openScaleActivity()
        }, 5000)

    }

    private
    fun openScaleActivity() {

        val intent = Intent(this, ScaleActivity::class.java)
        startActivity(intent)

    }
}