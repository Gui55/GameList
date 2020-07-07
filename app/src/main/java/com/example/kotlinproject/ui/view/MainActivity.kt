package com.example.kotlinproject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.koin.aModule
import com.example.kotlinproject.services.model.Game
import com.example.kotlinproject.ui.adapter.GameAdapter
import com.example.kotlinproject.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin(this, listOf(aModule))

        recycle.layoutManager = LinearLayoutManager(this)

        var viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewmodel.getTheGames().observe(this, object: Observer<ArrayList<Game>>{
            override fun onChanged(t: ArrayList<Game>?) {
                recycle.adapter = GameAdapter(t!!);
            }

        })
    }
}