package com.itc.music_app.di.module

import com.itc.music_app.presenter.RockMusicPresenter
import com.itc.music_app.presenter.RockMusicPresenterContract
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {

    @Binds
    abstract fun rockPresenter(
        rockMusicPresenter: RockMusicPresenter)
    : RockMusicPresenterContract



}