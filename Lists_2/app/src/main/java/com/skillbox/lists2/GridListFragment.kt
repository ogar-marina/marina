package com.skillbox.lists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.animators.ScaleInAnimator
import kotlinx.android.synthetic.main.fragment_user_list.*
import kotlin.random.Random

class GridListFragment : Fragment(R.layout.fragment_user_list) {

    private var persons = listOf(
        Person.Developer(
            id = 1,
            name = "Иван П.",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/1488/1488581.png",
            age = 25,
            programmingLanguage = "Java"
        ),
        Person.User(
            id = 2,
            name = "Петр И.",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/1909/1909953.png",
            age = 30
        ),
        Person.Developer(
            id = 3,
            name = "Елена С.",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/554/554857.png",
            age = 18,
            programmingLanguage = "Kotlin"
        ),
        Person.User(
            id = 4,
            name = "Даниил Л.",
            avatarLink = "https://cdn-icons-png.flaticon.com/512/3374/3374074.png",
            age = 26
        ),
        Person.Developer(
            id = 5,
            name = "Галина А.",
            avatarLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrEEQUcxq4NhNjq-XhA_oXKQuAaaTaHgr9UxPu7ia8L50zaBcfURZC2Bt93xzuQkRShec&usqp=CAU",
            age = 24,
            programmingLanguage = "C++"
        ),
        Person.User(
            id = 6,
            name = "Анна А.",
            avatarLink = "https://cdn.iconscout.com/icon/free/png-256/office-girl-16-1129480.png",
            age = 30
        )
    )

    private var personAdapter: PersonAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        addFab.setOnClickListener { addUser() }
        personAdapter?.items = persons
    }

    override fun onDestroyView() {
        super.onDestroyView()
        personAdapter = null
    }

    private fun initList() {
        personAdapter = PersonAdapter { position -> deletePerson(position) }
        with(userList) {
            adapter = personAdapter

            val dividerItemDecoration =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
            setHasFixedSize(true)
            itemAnimator = ScaleInAnimator()
        }
    }

    private fun deletePerson(position: Int) {
        persons = persons.filterIndexed { index, user -> index != position }
        personAdapter?.items = persons
    }

    private fun addUser() {
        val newUser = persons.random().let {
            when (it) {
                is Person.Developer -> it.copy(id = Random.nextLong())
                is Person.User -> it.copy(id = Random.nextLong())
            }
        }
        persons = listOf(newUser) + persons
        personAdapter?.items = persons
        userList.scrollToPosition(0)
    }
}