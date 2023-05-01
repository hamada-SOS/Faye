package com.example.faye

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.faye.databinding.CardLlistBinding

class CardAdapter(private val context: Context?) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // initialize the Data in the list
    val dataset = Datasource.cards

    class CardViewHolder(val binding: CardLlistBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val adapterLayout =
            CardLlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // 1- get the position
        val item = dataset[position]
        holder.binding.artistName.text = item.artistName
        holder.binding.movieName.text = item.movieName
        holder.binding.CardBackground.setImageResource(item.imageResourcedId)


    }


}