package com.example.kotlinproject.services.webservices

import com.example.kotlinproject.services.model.Game
import retrofit2.Call
import retrofit2.http.GET

interface Requisition {

    @GET("games_on_shop")
    fun getGames() : Call<ArrayList<Game>>

}