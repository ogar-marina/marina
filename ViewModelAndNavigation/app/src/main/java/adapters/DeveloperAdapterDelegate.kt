package adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.viewmodelandnavigation.Person
import com.example.viewmodelandnavigation.R
import com.example.viewmodelandnavigation.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class DeveloperAdapterDelegate(
    private val onItemClick: (id: Long) -> Unit,
    private val onLongClick: (position: Int) -> Unit,
) : AbsListItemAdapterDelegate<Person.Developer, Person, DeveloperAdapterDelegate.DeveloperHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): DeveloperHolder {
        return DeveloperHolder(
            parent.inflate(R.layout.item_developer),
            onItemClick,
            onLongClick
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
        onItemClick: (id: Long) -> Unit,
        onLongClick: (position: Int) -> Unit
    ) : BasePersonHolder(view, onItemClick, onLongClick) {

        init {
            view.setOnLongClickListener {
                onLongClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }

        private val programmingLanguageView: TextView =
            view.findViewById(R.id.programmingLanguageTextView)

        fun bind(person: Person.Developer) {
            bindMainInfo(person.id, person.name, person.avatarLink, person.age)
            programmingLanguageView.text = "Язык программирования ${person.programmingLanguage}"
        }

    }
}