package com.andresaftari.rvtutor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.andresaftari.rvtutor.databinding.ActivityMainBinding
import com.andresaftari.rvtutor.model.Movie
import com.andresaftari.rvtutor.utils.MainAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    @SuppressLint("Recycle")
    private fun setupRecyclerView() {
        val dataset = ArrayList<Movie>()

        val images = resources.obtainTypedArray(R.array.images)
        val title = resources.getStringArray(R.array.title)
        val genre = resources.getStringArray(R.array.genre)

        for (position in genre.indices) {
            dataset.add(
                Movie(
                    title[position],
                    genre[position],
                    images.getResourceId(position, -1)
                )
            )
        }

        val rvAdapter = MainAdapter(dataset) {
            Snackbar.make(
                binding.root,
                "Kamu baru aja ngetap film ${it.title}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvAdapter
            setHasFixedSize(true)
        }
    }
}