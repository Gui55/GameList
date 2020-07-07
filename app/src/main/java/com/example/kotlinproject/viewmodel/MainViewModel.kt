package com.example.kotlinproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinproject.services.model.Game
import com.example.kotlinproject.services.repository.GamesRepository

class MainViewModel : ViewModel() {

    fun getTheGames(): MutableLiveData<ArrayList<Game>>{

        return GamesRepository.instance.getTheGames()

    }

}