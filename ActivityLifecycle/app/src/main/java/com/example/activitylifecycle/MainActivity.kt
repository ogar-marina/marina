package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.activitylifecycle.FieldValidators.isStringContainNumber
import com.example.activitylifecycle.FieldValidators.isStringContainSpecialCharacter
import com.example.activitylifecycle.FieldValidators.isStringLowerAndUpperCase
import com.example.activitylifecycle.FieldValidators.isValidEmail
import com.example.activitylifecycle.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "MainActivity"

    private var state: FormState = FormState(false, "Авторизация прошла успешно!")

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

        setupListeners()

        binding.LoginButton.setOnClickListener {
            if (isValidate()) {
                updateTextView()
            }
        }

    }

    private fun isValidate(): Boolean =
        validateEmail() && validatePassword()

    private fun setupListeners() {
        binding.textEmail.addTextChangedListener(TextFieldValidation(binding.textEmail))
        binding.textPassword.addTextChangedListener(TextFieldValidation(binding.textPassword))
    }

    private fun validateEmail(): Boolean {
        if (binding.textEmail.text.toString().trim().isEmpty()) {
            binding.emailTextInputLayout.error = "Required Field!"
            binding.textEmail.requestFocus()
            return false
        } else if (!isValidEmail(binding.textEmail.text.toString())) {
            binding.emailTextInputLayout.error = "Invalid Email!"
            binding.textEmail.requestFocus()
            return false
        } else {
            binding.emailTextInputLayout.isErrorEnabled = false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        if (binding.textPassword.text.toString().trim().isEmpty()) {
            binding.passwordTextInputLayout.error = "Required Field!"
            binding.textPassword.requestFocus()
            return false
        } else if (binding.textPassword.text.toString().length < 6) {
            binding.passwordTextInputLayout.error = "password can't be less than 6"
            binding.textPassword.requestFocus()
            return false
        } else if (!isStringContainNumber(binding.textPassword.text.toString())) {
            binding.passwordTextInputLayout.error = "Required at least 1 digit"
            binding.textPassword.requestFocus()
            return false
        } else if (!isStringLowerAndUpperCase(binding.textPassword.text.toString())) {
            binding.passwordTextInputLayout.error =
                "Password must contain upper and lower case letters"
            binding.textPassword.requestFocus()
            return false
        } else if (!isStringContainSpecialCharacter(binding.textPassword.text.toString())) {
            binding.passwordTextInputLayout.error = "1 special character required"
            binding.textPassword.requestFocus()
            return false
        } else {
            binding.passwordTextInputLayout.isErrorEnabled = false
        }
        return true
    }

    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            when (view.id) {

                R.id.textEmail -> {
                    validateEmail()
                }
                R.id.textPassword -> {
                    validatePassword()
                }

            }
        }
    }

    private fun updateTextView(){
        if (isValidate()){
            binding.textView2.text = state.message
        } else {
            textView2.text = "Введите почту и пароль"
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

}
