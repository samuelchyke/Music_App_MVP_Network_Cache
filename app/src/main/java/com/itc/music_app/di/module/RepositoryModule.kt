package com.itc.music_app.di.module

import com.itc.music_app.repository.CacheMusicRepositoryImpl
import com.itc.music_app.repository.CacheRepository
import com.itc.music_app.repository.NetworkRepository
import com.itc.music_app.repository.MusicRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository( musicRepositoryImpl: MusicRepositoryImpl): NetworkRepository
    @Binds
    abstract fun provideCacheRepository( cacheRepositoryImpl: CacheMusicRepositoryImpl): CacheRepository



}