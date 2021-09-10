package com.example.intents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonPhone.setOnClickListener {
            call()
        }
    }

    companion object {
        private const val PHONE_REQUEST_CODE = 123
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PHONE_REQUEST_CODE) {
            Log.i("main", "call passes")
            if (resultCode == Activity.RESULT_OK) {
                toast("was called")
            } else {
                toast("Phone call was cancelled")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun call() {
        val number: String = binding.numberPhone.text.toString()

        val isPhoneValid = Patterns.PHONE.matcher(number).matches()

        if (!isPhoneValid) {
            toast("Enter valid phone number")
        } else {
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: $number")
            }

            if (callIntent.resolveActivity(packageManager) != null) {
                val phoneIntent = Intent(Intent.ACTION_DIAL)
                phoneIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(phoneIntent, PHONE_REQUEST_CODE)
                }
            } else {
                toast("No component to handle intent")
            }
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}

