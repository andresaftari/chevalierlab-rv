package com.andresaftari.rvtutor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresaftari.rvtutor.databinding.ActivityMainBinding

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
//        val images = resources.obtainTypedArray(R.array.images)
//        val title = resources.getStringArray(R.array.title)
//        val genre = resources.getStringArray(R.array.genre)

        TODO("Proses List RV")
    }
}