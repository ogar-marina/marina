package com.example.a01_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a01_constraintlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        binding.LoginButton.setOnClickListener {
            val progressBar = ProgressBar(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                )
            }
            binding.container.addView(progressBar)
            enable(false)
            Handler().postDelayed({
                binding.container.removeView(progressBar)
                enable(true)
                Toast.makeText(this, "Логин прошел успешно!", Toast.LENGTH_SHORT).show()
            }, 2000)
        }
    }

    private fun enable(b: Boolean) {

        binding.LoginButton.isEnabled = b
        binding.checkboxExample.isEnabled = b
        binding.textEmail.isEnabled = b
        binding.textPassword.isEnabled = b

    }
}