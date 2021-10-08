package com.skillbox.lists1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_list.*

class PersonListFragment : Fragment(R.layout.fragment_user_list) {

    private var dialog: AlertDialog? = null

    private var persons = listOf(
        Person.Developer(
            name = "Иван Петров",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/1488/1488581.png",
            age = 25,
            programmingLanguage = "Java"
        ),
        Person.User(
            name = "Петр Иванов",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/1909/1909953.png",
            age = 30
        ),
        Person.Developer(
            name = "Елена Сергеева",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/554/554857.png",
            age = 18,
            programmingLanguage = "Kotlin"
        ),
        Person.User(
            name = "Даниил Легкобыт",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/3374/3374074.png",
            age = 26
        ),
        Person.Developer(
            name = "Галина Андреева",
            avatarLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrEEQUcxq4NhNjq-XhA_oXKQuAaaTaHgr9UxPu7ia8L50zaBcfURZC2Bt93xzuQkRShec&usqp=CAU",
            age = 24,
            programmingLanguage = "C++"
        ),
        Person.User(
            name = "Анна Александрова",
            avatarLink = "https://cdn.iconscout.com/icon/free/png-256/office-girl-16-1129480.png",
            age = 30
        )
    )

    private var personAdapter: PersonAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        addFab.setOnClickListener { showDialogFragment() }
        personAdapter?.updatePersons(persons)
        personAdapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        personAdapter = null
    }

    private fun initList() {
        personAdapter = PersonAdapter { position -> deletePerson(position) }
        with(userList) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun deletePerson(position: Int) {

        if (userList.isNotEmpty()) {
            emptyListTextView.visibility = View.GONE
            persons = persons.filterIndexed { index, user -> index != position }
            personAdapter?.updatePersons(persons)
            personAdapter?.notifyItemRemoved(position)
        } else {
            emptyListTextView.visibility = View.VISIBLE
        }
    }

    private fun showDialogFragment() {
        DialogFragment()
            .show(childFragmentManager, "DialogTag")
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog?.dismiss()
    }
}
