package com.example.kotlinproject.koin

import com.example.kotlinproject.services.repository.GamesRepository
import com.example.kotlinproject.services.webservices.Requisition
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val aModule = module {

    single { Retrofit.Builder().baseUrl("https://5e737258be8c5400165c393c.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Requisition::class.java)}

}