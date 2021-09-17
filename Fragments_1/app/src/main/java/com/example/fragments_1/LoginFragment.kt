package com.example.fragments_1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LoginButton.setOnClickListener {
            login()
        }
    }

    private fun isValid() {
        val email: String = textEmail.text.toString().trim()
        val password: String = textPassword.text.toString().trim()

        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            textView2.text = "Заполните поля логина и пароля"
        } else if (email.isNullOrBlank()) {
            textView2.text = "Поле логина не заполнено"
        } else if (password.isNullOrBlank()) {
            textView2.text = "Поле пароля не заполнено"
        } else {
            openMainFragment()
        }
    }

    private fun login() {
        if (checkboxExample.isChecked) {
            isValid()
        } else {
            textView2.text = "Не принято соглашение"
        }
    }

    private fun openMainFragment(){
        (activity as? Navigator)?.navigateTo(MainFragment())
    }

}


