package com.itc.music_app.repository

import com.itc.music_app.api.MusicServiceApi
import com.itc.music_app.model.MusicResponse
import io.reactivex.Single
import javax.inject.Inject

interface NetworkRepository {

    fun getRockMusic(): Single<MusicResponse>
    fun getClassicMusic(): Single<MusicResponse>
    fun getPopMusic(): Single<MusicResponse>

}

class MusicRepositoryImpl @Inject constructor(
    private val musicService: MusicServiceApi,
) : NetworkRepository{

    override fun getRockMusic(): Single<MusicResponse> {
        return musicService.getMusic("rock")
    }

    override fun getClassicMusic(): Single<MusicResponse> {
        return musicService.getMusic("classic")
    }

    override fun getPopMusic(): Single<MusicResponse> {
        return musicService.getMusic("pop")
    }

}