package com.skillbox.lists2

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class DeveloperAdapterDelegate(
    private val onItemClick: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Person.Developer, Person, DeveloperAdapterDelegate.DeveloperHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): DeveloperHolder {
        return DeveloperHolder(
            parent.inflate(R.layout.item_developer),
            onItemClick
        )
    }

    override fun isForViewType(item: Person, items: MutableList<Person>, position: Int): Boolean {
        return item is Person.Developer
    }

    override fun onBindViewHolder(
        item: Person.Developer,
        holder: DeveloperHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class DeveloperHolder(
        view: View,
        onItemClick: (position: Int) -> Unit
    ) : PersonAdapter.BasePersonHolder(view, onItemClick) {

        private val programmingLanguageView: TextView =
            view.findViewById(R.id.programmingLanguageTextView)

        fun bind(person: Person.Developer) {
            bindMainInfo(person.name, person.avatarLink, person.age)
            programmingLanguageView.text = "${person.programmingLanguage}"
        }

    }
}