package com.andresaftari.rvtutor.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andresaftari.rvtutor.databinding.ItemMovieBinding
import com.andresaftari.rvtutor.model.Movie
import com.bumptech.glide.Glide

class MainAdapter(
    private val list: ArrayList<Movie>,
    val handler: (Movie) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvTitle.text = movie.title
                tvGenre.text = movie.genre

                Glide.with(this.root)
                    .load(movie.images)
                    .into(ivCover)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = with(holder) {
        bind(list[position])
        binding.root.setOnClickListener { handler(list[position]) }
    }

    override fun getItemCount() = list.size
}