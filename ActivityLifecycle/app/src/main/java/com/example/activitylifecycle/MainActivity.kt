package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "MainActivity"

    private var state: FormState = FormState(false, "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v(tag, "Main Activity onCreate ${hashCode()}")

        if (savedInstanceState != null) {
            state = savedInstanceState.getParcelable("KEY_STRING")
                ?: error("Unexpected state")
        }

        binding.button1.setOnClickListener {
            Thread.sleep(10000)
        }

        binding.LoginButton.setOnClickListener {
            if(binding.checkboxExample.isChecked){
                state = FormState(true,"")
                isValid()
            }else{
                state = FormState(false,"Не принято соглашение")
                binding.textView2.text = state.message
            }
        }
    }

    override fun onStart() {
        super.onStart()
        state != null
    }

    private fun isValid(){
        val email: String = binding.textEmail.text.toString().trim()
        val password: String = binding.textPassword.text.toString().trim()

        if(email.isNullOrBlank() && password.isNullOrBlank()){
            state = FormState(false,"Заполните поля логина и пароля")
            binding.textView2.text = state.message
        } else if (email.isNullOrBlank()){
            state = FormState(false,"Поле логина не заполнено")
            binding.textView2.text = state.message
        } else if (password.isNullOrBlank()) {
            state = FormState(false,"Поле пароля не заполнено")
            binding.textView2.text = state.message
        }else{
            state = FormState(false,"Авторизация прошла успешно!")
            binding.textView2.text = state.message
        }
    }

override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("KEY_STRING", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.textView2.text = savedInstanceState.getString("KEY")
    }
}
