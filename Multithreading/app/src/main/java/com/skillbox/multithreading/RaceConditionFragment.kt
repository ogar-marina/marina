package com.skillbox.multithreading

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_race_condition.*

class RaceConditionFragment : Fragment(R.layout.fragment_race_condition) {

    private var value: Int = 0

    private lateinit var amountOfN: EditText
    private lateinit var amountOfM: EditText
    private lateinit var result: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        amountOfN = view.findViewById(R.id.amountOfN)
        amountOfM = view.findViewById(R.id.amountOfM)
        result = view.findViewById(R.id.result)

        val withSync = view.findViewById<Button>(R.id.withSync)
        val withoutSync = view.findViewById<Button>(R.id.withoutSync)

        val tv = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.toString().isNullOrEmpty() && amountOfM.text.isNullOrEmpty()) {
                    withSync.isEnabled = false
                    withoutSync.isEnabled = false
                } else {
                    withSync.isEnabled = true
                    withoutSync.isEnabled = true
                }
            }
        }
        amountOfN.addTextChangedListener(tv)
        amountOfM.addTextChangedListener(tv)

        withoutSync.setOnClickListener {
            makeMultithreadingIIncrement(false)
        }

        withSync.setOnClickListener {
            makeMultithreadingIIncrement(true)
        }
    }

    private fun makeMultithreadingIIncrement(isSynchronized: Boolean) {
        val amountOfN = amountOfN.text.toString().toInt()
        val amountOfM = amountOfM.text.toString().toInt()

        makeMultithreadingIIncrement(amountOfN, amountOfM, isSynchronized)
    }

    private fun makeMultithreadingIIncrement(
        amountOfN: Int,
        amountOfM: Int,
        isSynchronized: Boolean
    ) {

        value = 0
        val threadCount = amountOfN
        val incrementCount = amountOfM
        val expectedValue = value + threadCount * incrementCount

        val counterValue = {
            for (i in 0 until incrementCount) {
                value++
            }
        }

        (0 until threadCount).map {
            Thread {
                if (isSynchronized) {
                    counterValue()
                } else {
                    counterValue()
                }
            }.apply {
                start()
            }
        }
            .map { it.join() }
        result.text = "Value = $value, Expected = $expectedValue"
    }
}