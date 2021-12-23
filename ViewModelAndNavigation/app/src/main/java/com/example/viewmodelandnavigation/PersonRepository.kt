package com.example.viewmodelandnavigation

import kotlin.random.Random

class PersonRepository {

    fun generatePersons(count: Int): List<Person> {
        val avatars = listOf(
            "https://cdn-icons-png.flaticon.com/512/1488/1488581.png",
            "https://cdn-icons-png.flaticon.com/512/1909/1909953.png",
            "https://cdn-icons-png.flaticon.com/512/554/554857.png",
            "https://cdn-icons-png.flaticon.com/512/3374/3374074.png"
        )

        val names = listOf(
            "Анна Александрова",
            "Галина Андреева",
            "Даниил Легкобыт",
            "Елена Сергеева"
        )

        val programmingLanguages = listOf(
            "Kotlin",
            "Java",
            "C++",
            "Python",
            "Javascript"
        )

        return (0..count).map {
            val id = it.toLong()
            val name = names.random()
            val avatar = avatars.random()
            val programmingLanguage = programmingLanguages.random()
            val isDeveloper = Random.nextBoolean()
            val age = Random.nextInt(15, 50)

            if (isDeveloper) {
                Person.Developer(
                    id = id,
                    name = name,
                    avatarLink = avatar,
                    age = age,
                    programmingLanguage = programmingLanguage
                )
            } else {
                Person.User(
                    id = id,
                    name = name,
                    avatarLink = avatar,
                    age = age
                )
            }
        }
    }

    fun createPerson(persons: List<Person>): List<Person> {
        val newPerson = generatePersons(1).first().let {
            when (it) {
                is Person.Developer -> it.copy(id = Random.nextLong())
                is Person.User -> it.copy(id = Random.nextLong())
            }
        }
        return listOf(newPerson) + persons
    }

    fun deletePerson(persons: List<Person>, position: Int): List<Person> {
        return persons.filterIndexed { index, user -> index != position }
    }
}