package com.itc.music_app.repository

import com.itc.music_app.api.MusicServiceApi
import com.itc.music_app.cache.MusicDAO
import com.itc.music_app.model.CacheMusic
import com.itc.music_app.model.MusicResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

interface CacheRepository {

    fun getCachedMusic(): Single<List<CacheMusic>>

    fun  insertRockMusic(music: List<CacheMusic>): Completable

    fun getRockMusic(): List<CacheMusic>

}

class CacheMusicRepositoryImpl @Inject constructor(
    private val musicDAO: MusicDAO
) : CacheRepository{

    override fun getCachedMusic(): Single<List<CacheMusic>> {
        return musicDAO.getAllMusic()
    }

    override fun insertRockMusic(music: List<CacheMusic>): Completable {
        return musicDAO.insertRockMusic(*music.toTypedArray())
    }

    override fun getRockMusic() : List<CacheMusic> {
        return musicDAO.getRockMusic()
    }
}
