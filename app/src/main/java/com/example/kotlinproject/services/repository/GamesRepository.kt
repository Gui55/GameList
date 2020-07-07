package com.example.kotlinproject.services.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlinproject.services.model.Game
import com.example.kotlinproject.services.webservices.Requisition
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GamesRepository : KoinComponent{

    companion object{
        val instance = GamesRepository()
    }

    val requisition: Requisition by inject()

    fun getTheGames() : MutableLiveData<ArrayList<Game>>{

        var games = MutableLiveData<ArrayList<Game>>()

        requisition.getGames().enqueue(object: Callback<ArrayList<Game>>{
            override fun onFailure(call: Call<ArrayList<Game>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<ArrayList<Game>>,
                response: Response<ArrayList<Game>>
            ) {
                games.value = response.body()
            }

        })
        return games
    }

}