package com.skillbox.lists1

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class DialogFragment : DialogFragment() {

    private val selectUsers: DataInterface?
        get() = parentFragment?.let { it as? DataInterface }
    private var addLanguage: EditText? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.add_user_dialog, null)
        val addName = dialogView.findViewById<EditText>(R.id.add_name)
        val addLinkPhoto = dialogView.findViewById<EditText>(R.id.add_linkPhoto)
        val addAge = dialogView.findViewById<EditText>(R.id.add_age)
        addLanguage = dialogView.findViewById(R.id.add_language)
        val radioButtonUser = dialogView.findViewById<RadioButton>(R.id.radioButtonUser)
        val radioButtonDeveloper = dialogView.findViewById<RadioButton>(R.id.radioButtonDeveloper)

        var newUser: List<Person>

        radioButtonUser.setOnClickListener {
            changeShowEdit(false)
        }
        radioButtonDeveloper.setOnClickListener {
            changeShowEdit(true)

        }

        return AlertDialog.Builder(requireActivity())
            .setTitle("Add")
            .setView(dialogView)
            .setPositiveButton("OK") { _, _ ->
                if (radioButtonUser.isChecked) {

                    newUser = listOf(
                        Person.User(
                            addName.text.toString(),
                            addLinkPhoto.text.toString(),
                            addAge.text.toString().toInt()
                        )
                    )
                } else {
                    newUser = listOf(
                        Person.Developer(
                            addName.text.toString(),
                            addLinkPhoto.text.toString(),
                            addAge.text.toString().toInt(),
                            addLanguage?.text.toString()
                        )
                    )
                }
                selectUsers?.selectUsers(newUser)
            }
            .setNegativeButton("Отмена") { _, wich -> }
            .create()
    }

    private fun changeShowEdit(showType: Boolean) {
        addLanguage?.run { isVisible = showType }
    }

}

