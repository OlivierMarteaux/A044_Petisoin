package com.example.a044_petisoin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.a044_petisoin.ui.home.AnimalsAdapter
import com.example.a044_petisoin.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // instance du viewModel
    private val viewModel: HomeViewModel by viewModels()
    // instance de l'adapter
    private val adapter = AnimalsAdapter(emptyList())

    // creation de l'activite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerView))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        observeAnimals()
    }

    private fun observeAnimals() {
        lifecycleScope.launch {
            viewModel.animals.collect {
                adapter.update(it)
            }
        }
    }
}