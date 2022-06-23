package com.itc.music_app.di

import com.itc.music_app.di.module.ApiModule
import com.itc.music_app.di.module.ApplicationModule
import com.itc.music_app.di.module.PresenterModule
import com.itc.music_app.di.module.RepositoryModule
import com.itc.music_app.ui.MainActivity
import com.itc.music_app.ui.RockFragment
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class,
        ApiModule::class,
        RepositoryModule::class,
        PresenterModule::class
    ]
)
interface MusicComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(rockFragment: RockFragment)




}