package com.example.animation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animation.databinding.ActivityMainBinding
import com.google.android.material.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val animationFade = android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.fade)
        binding.imageViewIV.startAnimation(animationFade)
        val animationMove = android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.move)
        binding.startBTN.startAnimation(animationMove)
        binding.startBTN.setOnClickListener {
            val intent =  Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}