package com.example.mad_practical_6_22012011067

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var heartAnimationDrawable: AnimationDrawable
    private lateinit var clockAnimationDrawable: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val heartImg = findViewById<ImageView>(R.id.heartAnim)
        val clockImg = findViewById<ImageView>(R.id.clockImg)
        heartImg.setBackgroundResource(R.drawable.heart_animation_list)
        clockImg.setBackgroundResource(R.drawable.clock_animation_list)
        heartAnimationDrawable = heartImg.background as AnimationDrawable
        clockAnimationDrawable = clockImg.background as AnimationDrawable }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) { heartAnimationDrawable.start()
            clockAnimationDrawable.start()
        }
        else { heartAnimationDrawable.stop()
            clockAnimationDrawable.stop()
        }
    }
}