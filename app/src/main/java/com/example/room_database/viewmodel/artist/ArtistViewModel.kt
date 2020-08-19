package com.example.room_database.viewmodel.artist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room_database.room.AppRoomDatabase
import com.example.room_database.room.artist.Artist
import com.example.room_database.room.artist.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ArtistRepository
    val allArtist: LiveData<List<Artist>>

    init {
        val artistDao = AppRoomDatabase.getDatabaseInstance(application).artistDao()
        repository = ArtistRepository(artistDao)
        allArtist = repository.allArtist
    }

    fun createNewArtist(artist: Artist) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createArtist(artist)
        }
    }
}