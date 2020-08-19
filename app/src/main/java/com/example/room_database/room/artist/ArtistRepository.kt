package com.example.room_database.room.artist

import androidx.lifecycle.LiveData

class ArtistRepository(private val artistDao: ArtistDao) {
    val allArtist = artistDao.getAllArtist()
    fun createArtist(artist: Artist) {
        artistDao.createArtist(artist)
    }
}