package com.itc.music_app

import android.app.Application
import com.itc.music_app.di.DaggerMusicComponent
import com.itc.music_app.di.MusicComponent
import com.itc.music_app.di.module.ApplicationModule

class MusicApp : Application() {

    override fun onCreate(){
        super.onCreate()
        component = DaggerMusicComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object{

        lateinit var component : MusicComponent

    }

}