package com.example.kotlinproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.services.model.Game
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_line.view.*

class GameAdapter(var games: ArrayList<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_line, parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        var game = games[position]

        Picasso.get().load(game.image).into(holder.gamePhoto)

        holder.gameName.text = game.name
        holder.gameGenre.text = game.genre
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gameName = itemView.gameName
        var gameGenre = itemView.gameGenre
        var gamePhoto = itemView.gamePhoto
    }
}