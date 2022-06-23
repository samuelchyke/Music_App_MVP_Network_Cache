package com.itc.music_app.api

import com.itc.music_app.model.MusicResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicServiceApi {

    @GET(SONG_PATH)
    fun getMusic(
        @Query("term") musicType : String,
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("amp;limit") limit: Int = 50
    ) : Single<MusicResponse>

    companion object {

        const val BASE_URL = "https://itunes.apple.com/"
        const val SONG_PATH = "search"
        const val ROCK_PATH = "search?term=rock&amp;media=music&amp;entity=song&amp;limit=50"

    }
}