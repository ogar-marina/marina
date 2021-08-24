package com.example.viewandlayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.LoginButton)


        loginButton.setOnClickListener {
            login()
        }

    }

    @SuppressLint("WrongViewCast")
    private fun login() {
        val progressBar = ProgressBar(this)
        progressBar.layoutParams = LinearLayout.LayoutParams(

            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val layout = findViewById<RelativeLayout>(R.id.layout)

        layout?.addView(progressBar)

        val button = findViewById<Button>(R.id.LoginButton)

        button?.setOnClickListener {

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
