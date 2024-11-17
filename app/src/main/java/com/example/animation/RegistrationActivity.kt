package com.example.animation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animation.databinding.ActivityMainBinding
import com.example.animation.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val animationMoveTop =
            android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.move_top)
        binding.textViewTV.startAnimation(animationMoveTop)
        val animationMoveBot =
            android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.move_bot)
        binding.linearLayoutLL.startAnimation(animationMoveBot)
        binding.regBTN.setOnClickListener {
            if (binding.nameET.text.isNotEmpty() && binding.passET.text.isNotEmpty()) {
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Заполните поля!", Toast.LENGTH_LONG).show()
            }
        }
    }
}