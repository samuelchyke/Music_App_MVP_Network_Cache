package com.itc.music_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music_database")
data class CacheMusic(

    @PrimaryKey
    val id: Int,
    val artistName: String,
    val artworkUrl60: String,
    val collectionName: String,
    val trackPrice: Double,
)

fun List<Music>.mapToCache(): List<CacheMusic> {
    return this.map { music ->
        CacheMusic(
            id =  music.artistId ?: 999,
            artistName =  music.artistName ?: "",
            artworkUrl60 =  music.artworkUrl60?: "",
            collectionName =  music.collectionName?: "",
            trackPrice = music.trackPrice ?: 0.0
        )
    }

}