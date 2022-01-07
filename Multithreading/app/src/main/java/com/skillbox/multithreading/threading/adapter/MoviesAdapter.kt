package com.skillbox.multithreading.threading.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.multithreading.R
import com.skillbox.multithreading.networking.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var moviesList = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = moviesList[position]
        holder.setData(location)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setData(moviesList: List<Movie>) {
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun setData(movie: Movie) {
            itemView.title.text = movie.title
            itemView.year.text = movie.year.toString()
        }
    }
}
