package adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.viewmodelandnavigation.Person
import com.example.viewmodelandnavigation.R
import com.example.viewmodelandnavigation.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class UserAdapterDelegate(
    private val onItemClick: (id: Long) -> Unit,
    private val onLongClick: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Person.User, Person, UserAdapterDelegate.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): UserHolder {
        return UserHolder(
            parent.inflate(R.layout.item_user),
            onItemClick,
            onLongClick
        )
    }

    override fun isForViewType(item: Person, items: MutableList<Person>, position: Int): Boolean {
        return item is Person.User
    }

    override fun onBindViewHolder(
        item: Person.User,
        holder: UserHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class UserHolder(
        view: View,
        onItemClick: (id: Long) -> Unit,
        onLongClick: (position: Int) -> Unit
    ) : BasePersonHolder(view, onItemClick, onLongClick) {
        init {
            view.findViewById<TextView>(R.id.developerTextView).isVisible = false
            view.setOnLongClickListener {
                onLongClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }

        fun bind(person: Person.User) {
            bindMainInfo(person.id, person.name, person.avatarLink, person.age)
        }
    }
}