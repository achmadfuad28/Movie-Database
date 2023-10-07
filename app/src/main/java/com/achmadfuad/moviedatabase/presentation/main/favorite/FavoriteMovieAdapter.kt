package com.achmadfuad.moviedatabase.presentation.main.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.achmadfuad.core.extension.loadImageWithRadius
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.ItemFavoriteMovieBinding

class FavoriteMovieAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<Movie, FavoriteMovieAdapter.MovieViewHolder>(MovieDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_movie, parent, false)
        val binding = ItemFavoriteMovieBinding.bind(view)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            holder.bind(movie)
            holder.itemView.setOnClickListener {
                onClick.invoke(movie.imdbID)
            }
        }
    }

    class MovieViewHolder(private val binding: ItemFavoriteMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Movie) {
            binding.apply {
                ivMovie.loadImageWithRadius(data.poster)
            }

        }
    }

    object MovieDiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.imdbID == newItem.imdbID

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }
}
