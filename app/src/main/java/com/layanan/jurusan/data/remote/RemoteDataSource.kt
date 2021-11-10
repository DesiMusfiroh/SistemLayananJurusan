package com.layanan.jurusan.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.layanan.jurusan.data.News

class RemoteDataSource {
    companion object {
        fun getInstance(): RemoteDataSource {
            return RemoteDataSource()
        }
        private const val TAG = "Remote Data Source"
    }

    fun getNews(): LiveData<ArrayList<News>> {
        val results = MutableLiveData<ArrayList<News>>()

        return results
    }

}