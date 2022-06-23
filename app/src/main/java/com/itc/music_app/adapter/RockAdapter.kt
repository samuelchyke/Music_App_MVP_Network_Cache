package com.itc.music_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itc.music_app.R
import com.itc.music_app.model.CacheMusic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_view.view.*

class RockAdapter(
    private val mCacheMusicList: MutableList<CacheMusic> = mutableListOf(),
) : RecyclerView.Adapter<RockAdapter.MyViewHolder>(
) {

    fun setMusic(songs: List<CacheMusic>) {
        mCacheMusicList.clear()
        mCacheMusicList.addAll(songs)
        notifyDataSetChanged()
    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rockMusic = mCacheMusicList[position]
        holder.itemView.tv_artist_name.text = rockMusic.artistName
        holder.itemView.tv_collection_name.text = rockMusic.collectionName
        holder.itemView.tv_track_price.text = rockMusic.trackPrice.toString()

        Picasso.get()
            .load(rockMusic.artworkUrl60)
            .placeholder(R.drawable.ic_home)
            .error(R.drawable.ic_pop)
            .fit()
            .into(holder.itemView.iv_artwork)
        }

    override fun getItemCount(): Int  = mCacheMusicList.size

}
