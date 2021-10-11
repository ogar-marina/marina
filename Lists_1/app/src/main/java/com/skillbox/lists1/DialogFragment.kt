package com.skillbox.lists1

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.add_user_dialog.*

class DialogFragment : DialogFragment() {

    private val selectUsers: DataInterface?
        get() = parentFragment?.let { it as? DataInterface }
    private var add_language: EditText? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var newUser: List<Person>

        radioButtonUser?.setOnClickListener {
            changeShowEdit(false)
        }
        radioButtonDeveloper.setOnClickListener {
            changeShowEdit(true)

        }

        return AlertDialog.Builder(requireActivity())
            .setTitle("Добавить")
            .setView(R.layout.add_user_dialog)
            .setPositiveButton("OK") { _, _ ->
                if (radioButtonUser.isChecked) {

                    newUser = listOf(
                        Person.User(
                            add_name.text.toString(),
                            add_linkPhoto.text.toString(),
                            add_age.inputType
                        )
                    )
                } else {
                    newUser = listOf(
                        Person.Developer(
                            add_name.text.toString(),
                            add_linkPhoto.text.toString(),
                            add_age.inputType,
                            add_language?.text.toString()
                        )
                    )
                }
                selectUsers?.selectUsers(newUser)
            }
            .setNegativeButton("Отмена") { _, wich -> }
            .create()
    }

    private fun changeShowEdit(showType: Boolean) {
        add_language?.run { isVisible = showType }
    }

}

