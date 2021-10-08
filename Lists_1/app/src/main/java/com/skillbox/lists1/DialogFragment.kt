package com.skillbox.lists1

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val newUser = arrayOf("User", "Developer")
        return AlertDialog.Builder(requireActivity())
            .setTitle("Добавить")
            .setView(R.layout.add_user_dialog)
            .setPositiveButton("Ok", { _, _ ->  })
            .setNegativeButton("Cancle", { _, _ ->  })
            .setItems(newUser) { _, which -> }
            .create()
    }
}