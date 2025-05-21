package com.example.a044_petisoin.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a044_petisoin.databinding.AnimalCardBinding
import com.example.a044_petisoin.model.Animal

class AnimalsAdapter(private var animals: List<Animal>) :
    RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>()
{
    inner class AnimalViewHolder(binding: AnimalCardBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        private val id: TextView = binding.id
        private val type: TextView = binding.type
        private val name: TextView = binding.name
        fun bind(animal: Animal)
        {
            id.text = animal.id.toString()
            type.text = animal.type.name
            name.text = animal.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder
    {
        val binding = AnimalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int)
    {
        holder.bind(animals[position])
    }
    override fun getItemCount(): Int =
        animals.size
    fun update(animals: List<Animal>)
    {
        this.animals = animals
        notifyDataSetChanged()
    }
}