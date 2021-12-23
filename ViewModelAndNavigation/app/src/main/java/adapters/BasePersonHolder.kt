package adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewmodelandnavigation.R

abstract class BasePersonHolder(
    view: View,
    onItemClick: (id: Long) -> Unit,
    onLongClick: (position: Int) -> Unit,
) : RecyclerView.ViewHolder(view) {

    private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    private val ageTextView: TextView = view.findViewById(R.id.ageTextView)
    private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

    private var currentId: Long? = null

    init {
        view.setOnClickListener {
            currentId?.let {
                onItemClick(it)
            }
        }
        view.setOnLongClickListener {
            onLongClick(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    protected fun bindMainInfo(
        id: Long,
        name: String,
        avatarLink: String,
        age: Int
    ) {
        currentId = id
        nameTextView.text = name
        ageTextView.text = "Возраст = ${age}"

        Glide.with(itemView)
            .load(avatarLink)
            .placeholder(R.drawable.ic_portrait)
            .into(avatarImageView)
    }
}