package com.itc.music_app.model


import com.google.gson.annotations.SerializedName

data class MusicResponse(
    @SerializedName("resultCount")
    val resultCount: Int?,
    @SerializedName("results")
    val results: List<Music>
)