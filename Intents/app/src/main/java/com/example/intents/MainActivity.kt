package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //https://skillbox.ru/course/profession-android-developer-2021/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginButton.setOnClickListener {
                login()
            }
        }


    private fun toSecondActivity() {
        val email: String = binding.textEmail.text.toString()

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (!isEmailValid) {
            toast("Enter valid email address")
        } else {
            val activityClass = SecondActivity::class.java
            val secondActivityIntent = Intent(
                this,
                activityClass
            )
            startActivity(secondActivityIntent)
            finish()
        }
    }

    private fun isValid(){
        val email: String = binding.textEmail.text.toString().trim()
        val password: String = binding.textPassword.text.toString().trim()

        if(email.isNullOrBlank() && password.isNullOrBlank()){
            binding.textView2.text = "Заполните поля логина и пароля"
        } else if (email.isNullOrBlank()){
            binding.textView2.text = "Поле логина не заполнено"
        } else if (password.isNullOrBlank()) {
            binding.textView2.text = "Поле пароля не заполнено"
        }else{
            toSecondActivity()
        }
    }

    private fun login() {
        if(binding.checkboxExample.isChecked){
            isValid()
            toSecondActivity()
        }else{
            binding.textView2.text = "Не принято соглашение"
        }
    }



    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}