package com.example.spotifyclone.data.remote

import com.example.spotifyclone.Utils.Constants.SONG_COLLECTIONS
import com.example.spotifyclone.data.entities.Song
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTIONS)

    suspend fun getAllSongs(): List<Song>
    {
        return try {
            songCollection.get().await()
                .toObjects(Song::class.java)
        }
        catch (e: Exception)
        {
            emptyList()
        }
    }
}