package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "MainActivity"

    private var state: FormState = FormState(false, "Авторизация прошла успешно!")

    private val validEmail = "marina"
    private val validPassword = "qwerty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v(tag, "Main Activity onCreate ${hashCode()}")

        if (savedInstanceState != null) {
            state = savedInstanceState.getParcelable<FormState>("KEY_STRING")
                ?: error("Unexpected state")
            updateTextView()
        }

        val newTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkIfAllFieldsChecked()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }
        binding.textEmail.addTextChangedListener(newTextWatcher)
        binding.textPassword.addTextChangedListener(newTextWatcher)

        binding.checkboxExample.setOnCheckedChangeListener { buttonView, isChecked ->
            checkIfAllFieldsChecked()
        }

        binding.button1.setOnClickListener {
            Thread.sleep(10000)
        }

        binding.LoginButton.setOnClickListener {
            login()
            updateTextView()
        }
    }

    fun checkIfAllFieldsChecked() {
        val usernameInput: String = binding.textEmail.text.toString().trim()
        val passwordInput: String = binding.textPassword.text.toString().trim()

        binding.LoginButton.isEnabled =
            usernameInput.isNotEmpty() && passwordInput.isNotEmpty() && binding.checkboxExample.isChecked
    }

    fun EmailAndPasswordValid(): Boolean {
        return binding.textEmail.text.toString()
            .trim() == validEmail && binding.textPassword.text.toString().trim() == validPassword
    }

    private fun updateTextView() {
        if (EmailAndPasswordValid()) {
            binding.textView2.text = state.message
        } else {
            binding.textView2.text = "Введите логин и пароль"
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

    companion object {
        private const val KEY_STRING = "String"
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
            }, 2000)
        }
        updateTextView()
    }

    private fun enable(b: Boolean) {

        binding.LoginButton.isEnabled = b
        binding.checkboxExample.isEnabled = b
        binding.textEmail.isEnabled = b
        binding.textPassword.isEnabled = b
        binding.checkboxExample.isEnabled = b

    }
}
