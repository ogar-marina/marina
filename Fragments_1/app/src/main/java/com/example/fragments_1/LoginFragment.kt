package com.example.fragments_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        LoginButton.setOnClickListener {
            if (checkboxExample.isChecked) {
                isValid()
            } else {
                textView2.text = "Не принято соглашение"
            }
        }
    }

   fun replaceFragment() {

        val transaction:FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.container2, MainFragment())
        transaction .commit()
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
            replaceFragment()
        }
    }
}


