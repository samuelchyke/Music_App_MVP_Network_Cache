package com.itc.music_app.presenter

import android.util.Log
import com.itc.music_app.adapter.RockAdapter
import com.itc.music_app.model.CacheMusic
import com.itc.music_app.model.mapToCache
import com.itc.music_app.repository.CacheRepository
import com.itc.music_app.repository.NetworkRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RockMusicPresenter @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val networkRepo: NetworkRepository,
    private val cacheRepo: CacheRepository
) : RockMusicPresenterContract{

    private var rockMusicViewContract : RockMusicViewContract? = null
    
    override fun init(viewContract: RockMusicViewContract) {
        rockMusicViewContract = viewContract
    }

    override fun destroyPresenter() {
        rockMusicViewContract = null
        compositeDisposable.dispose()
    }

    override fun getRockMusic() {
        rockMusicViewContract?.loading(true)
        getRockMusicFromNetwork()
    }

    override fun registerNetworkState() {

    }

    private fun getRockMusicFromNetwork() {
        networkRepo.getRockMusic()
            .subscribeOn(Schedulers.io())
            .flatMapCompletable {
                cacheRepo.insertRockMusic(it.results.mapToCache())
                }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { getRockMusicFromCache()},
                { error ->
                    rockMusicViewContract?.error(error)
                    getRockMusicFromCache()
                }
            )
            .also { compositeDisposable.add(it) }

    }

    private fun getRockMusicFromCache() {
        cacheRepo.getCachedMusic()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    rockMusicViewContract?.success(it as MutableList<CacheMusic>, true)
                },
                {
                    rockMusicViewContract?.error(it)
                    getRockMusicFromCache()
                }
            )
            .also { compositeDisposable.add(it) }

    }
}

interface  RockMusicPresenterContract {

    fun init(viewContract: RockMusicViewContract)

    fun destroyPresenter()

    fun getRockMusic()

    fun registerNetworkState()

}

interface RockMusicViewContract{

    fun loading(isLoading: Boolean = false)
    fun success(music: List<CacheMusic>, isOffline: Boolean = false)
    fun error(error:Throwable)

}