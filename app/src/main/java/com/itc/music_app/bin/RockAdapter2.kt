package com.itc.music_app.bin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.itc.music_app.R
import com.itc.music_app.api.MusicServiceApi
import com.itc.music_app.model.CacheMusic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_view.view.*
//
//
//class RockAdapter2 : ListAdapter<CacheMusic, RockAdapter.MusicViewHolder>(MusicDiffCallback()) {
//
//    private var mCacheMusicList: List<CacheMusic> = emptyList()
//
//    fun setMusic(cacheMusics: List<CacheMusic>) {
//        this.mCacheMusicList = cacheMusics
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
//        return MusicViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
////    override fun getItemCount(): Int = mCacheMusicList.size
//
//    class MusicViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(item: CacheMusic) = with(itemView) {
//
//            itemView.tv_artist_name.text = item.artistName
//            itemView.tv_collection_name.text = item.collectionName
//            itemView.tv_track_price.text = item.trackPrice.toString()
//
//            Picasso.get()
//                .load(MusicServiceApi.ROCK_PATH + item.artworkUrl60)
//                .placeholder(R.drawable.ic_home)
//                .error(R.drawable.ic_home)
//                .fit()
//                .into(itemView.iv_artwork)
//        }
//
//        //For inflating the layout in onCreateViewHolder()
//        //TODO: Make sure your layout name is resolved
//        companion object {
//            fun from(parent: ViewGroup): MusicViewHolder {
//                val view =
//                    LayoutInflater.from(parent.context).inflate(R.layout.music_view, parent, false)
//                return MusicViewHolder(view)
//            }
//        }
//    }
//}
//
//class MusicDiffCallback() : DiffUtil.ItemCallback<CacheMusic>() {
//
//    override fun areItemsTheSame(oldItem: CacheMusic, newItem: CacheMusic): Boolean {
//        //TODO: Confirm that your id variable matches this one or change this one to match
//        //the one in your model
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: CacheMusic, newItem: CacheMusic): Boolean {
//        return oldItem == newItem
//    }
//
//}