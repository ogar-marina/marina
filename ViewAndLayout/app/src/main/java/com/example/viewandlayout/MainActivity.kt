package com.example.viewandlayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.LoginButton)


        loginButton.setOnClickListener {
            login()
        }

    }


    private fun login() {

        val loginButton = findViewById<Button>(R.id.LoginButton)
        val container = findViewById<LinearLayout>(R.id.container)

        loginButton.setOnClickListener {
            val progressBar = ProgressBar(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                )
               }
            container.addView(progressBar)

            progressBar.visibility = View.VISIBLE
            enable(false)

            Handler().postDelayed({
                progressBar.visibility = View.GONE
                enable(true)

                Toast.makeText(this, "Логин прошел успешно!", Toast.LENGTH_SHORT).show()
            }, 2000)


         }


    }


    private fun enable(b: Boolean) {
        val loginButton = findViewById<Button>(R.id.LoginButton)
        val checkBoxExample = findViewById<CheckBox>(R.id.checkboxExample)
        val textEmail = findViewById<EditText>(R.id.textEmail)
        val textPassword = findViewById<EditText>(R.id.textPassword)

        loginButton.isEnabled = b
        checkBoxExample.isEnabled = b
        textEmail.isEnabled = b
        textPassword.isEnabled = b
    }
}
