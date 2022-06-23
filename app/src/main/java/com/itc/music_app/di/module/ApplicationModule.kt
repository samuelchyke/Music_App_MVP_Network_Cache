package com.itc.music_app.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.itc.music_app.adapter.RockAdapter
import com.itc.music_app.cache.MusicDAO
import com.itc.music_app.cache.MusicDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesContext(): Context = application.applicationContext

    @Provides
    fun providesRoomDb(context: Context): MusicDatabase = Room.databaseBuilder(
        context,
        MusicDatabase::class.java,
        "music-db"
    ).build()

    @Provides
    fun providesCardsDAO(database: MusicDatabase): MusicDAO =
        database.musicDao()

    @Provides
    fun provideRockAdapter(): RockAdapter =
        RockAdapter()
}