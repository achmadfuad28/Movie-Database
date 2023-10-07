package com.achmadfuad.moviedatabase.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.achmadfuad.core.extension.loadImageWithRadius
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.ItemMovieBinding

class MovieAdapter(private val onClick: (String) -> Unit) :
    PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        val binding = ItemMovieBinding.bind(view)
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

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Movie) {
            binding.apply {
                ivMovie.loadImageWithRadius(data.poster)
                tvTitle.text = data.title
                tvYear.text = data.year
                tvType.text = data.type
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
