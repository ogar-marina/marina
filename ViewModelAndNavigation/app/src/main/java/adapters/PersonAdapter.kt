package adapters

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.example.viewmodelandnavigation.Person
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class PersonAdapter(
    private val onItemClick: (id: Long) -> Unit,
    private val onLongClick: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<Person>(PersonDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(UserAdapterDelegate(onItemClick, onLongClick))
            .addDelegate(DeveloperAdapterDelegate(onItemClick, onLongClick))
    }
}

class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return when {
            oldItem is Person.Developer && newItem is Person.Developer -> oldItem.id == newItem.id
            oldItem is Person.User && newItem is Person.User -> oldItem.id == newItem.id
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}
