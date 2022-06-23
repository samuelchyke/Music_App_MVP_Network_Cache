package com.itc.music_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.music_app.MusicApp
import com.itc.music_app.adapter.RockAdapter
import com.itc.music_app.databinding.FragmentRockBinding
import com.itc.music_app.model.CacheMusic
import com.itc.music_app.presenter.RockMusicPresenterContract
import com.itc.music_app.presenter.RockMusicViewContract
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_rock.view.*

class RockFragment : Fragment(), RockMusicViewContract{

    @Inject
    lateinit var rockPresenter: RockMusicPresenterContract

    @Inject
    lateinit var rockAdapter: RockAdapter

    private val binding by lazy{
        FragmentRockBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicApp.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initRockPresenter()
        initRecyclerView()

        return binding.root

    }

    private fun initRockPresenter(){
        //Presenter
        rockPresenter.init(this)
        rockPresenter.registerNetworkState()
        rockPresenter.getRockMusic()

    }

    private fun initRecyclerView(){
        //Recycler View
        binding.recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = rockAdapter
        }
    }

    override fun loading(isLoading: Boolean) {
//        TODO("Not yet implemented")
    }

    override fun success(music: List<CacheMusic>, isOffline: Boolean) {
        rockAdapter.setMusic(music)
//        TODO("Not yet implemented")
    }

    override fun error(error: Throwable) {
//        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        rockPresenter.destroyPresenter()
        super.onDestroyView()
    }
}

//        val view = inflater.inflate(R.layout.fragment_rock, container, false)
//        val recyclerView = view?.recyclerView
//        recyclerView.apply{
//            this?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//            this?.adapter = rockAdapter
//        }