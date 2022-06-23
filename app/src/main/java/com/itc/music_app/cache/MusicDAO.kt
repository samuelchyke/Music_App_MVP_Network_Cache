package com.itc.music_app.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itc.music_app.model.CacheMusic
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MusicDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRockMusic(vararg cacheMusic: CacheMusic) : Completable

    @Query("SELECT * FROM music_database")
    fun getAllMusic(): Single<List<CacheMusic>>

    @Query("SELECT * FROM music_database")
    fun getRockMusic(): List<CacheMusic>

    @Query("SELECT * FROM music_database WHERE id LIKE:artistId")
    fun getMusicById(artistId: Int): Single<CacheMusic>

}