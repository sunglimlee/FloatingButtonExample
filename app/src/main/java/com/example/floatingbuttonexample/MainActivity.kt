package com.example.floatingbuttonexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import androidx.core.animation.addListener

class MainActivity : AppCompatActivity() {
    private lateinit var button_reveal : Button
    private lateinit var button_hide : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_reveal = findViewById(R.id.button_reveal)
        button_reveal.setOnClickListener {
            revealFAB()
        }
        button_hide = findViewById(R.id.button_hide)
        button_hide.setOnClickListener {
            hideFAB()
        }
    }
    private fun revealFAB() {
        var v : View = findViewById(R.id.fab)
        val cx : Int = v.width / 2
        val cy : Int = v.height /2
        //radius 반지름 구하기
        val finalRadius : Double = Math.hypot(cx.toDouble(), cy.toDouble())
        val anim : Animator = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0F, finalRadius.toFloat())
        v.visibility = View.VISIBLE
        anim.start()
    }
    private fun hideFAB() {
        var v : View = findViewById(R.id.fab)
        val cx : Int = v.width / 2
        val cy : Int = v.height /2
        //radius 반지름 구하기
        val initialRadius : Double = Math.hypot(cx.toDouble(), cy.toDouble())
        val anim : Animator = ViewAnimationUtils.createCircularReveal(v, cx, cy,  initialRadius.toFloat(), 0F)
        anim.setDuration(3000)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                super.onAnimationEnd(animation, isReverse)
                //v.visibility = View.INVISIBLE
            }
        })
        anim.start()
        v.visibility = View.INVISIBLE

    }
}