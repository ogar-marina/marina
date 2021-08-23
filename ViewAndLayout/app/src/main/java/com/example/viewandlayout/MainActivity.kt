package com.example.viewandlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.LoginButton)


        loginButton.setOnClickListener {
            makeOperation()
        }

    }

    private fun makeOperation(){
        val longOperationProgress = findViewById<ProgressBar>(R.id.longOperationProgress)
        val loginButton = findViewById<Button>(R.id.LoginButton)
        val checkBoxExample = findViewById<CheckBox>(R.id.checkboxExample)
        val textEmail = findViewById<EditText>(R.id.textEmail)
        val textPassword = findViewById<EditText>(R.id.textPassword)

        longOperationProgress.visibility = View.VISIBLE
        loginButton.isEnabled = false
        checkBoxExample.isEnabled = false
        textEmail.isEnabled = false
        textPassword.isEnabled = false

        Handler().postDelayed({
            longOperationProgress.visibility = View.GONE
            loginButton.isEnabled = true
            checkBoxExample.isEnabled = true
            textEmail.isEnabled = true
            textPassword.isEnabled = true

            Toast.makeText(this, "Логин прошел успешно!", Toast.LENGTH_SHORT).show()
        }, 2000)
    }
}