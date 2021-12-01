package com.layanan.jurusan.data.remote.response

import com.google.gson.annotations.SerializedName
import com.layanan.jurusan.data.NewsModel

data class ListNewsResponse(
    @SerializedName("berita")
    val news: MutableList<NewsModel>
)
