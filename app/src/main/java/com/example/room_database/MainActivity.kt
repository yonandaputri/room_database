package com.example.room_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room_database.room.artist.Artist
import com.example.room_database.viewmodel.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val artistViewModel by viewModels<ArtistViewModel>()
    lateinit var artistRecyclerViewAdapter: ArtistRecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistViewModel.allArtist.observe(this, Observer {
            artistRecyclerViewAdapter = ArtistRecycleViewAdapter(it)
            artistRecyclerView.adapter = artistRecyclerViewAdapter
        })
    }

    fun addNewArtist(v: View) {
        val name = artistNameInputText.text.toString()
        val debut = debutInputText.text.toString()
        artistViewModel.createNewArtist(Artist(name = name, debut = debut, originPlace = ""))
    }

}