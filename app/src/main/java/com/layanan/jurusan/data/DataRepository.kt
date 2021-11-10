package com.layanan.jurusan.data

import androidx.lifecycle.LiveData
import com.layanan.jurusan.data.remote.RemoteDataSource

class DataRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
) {
    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(remoteData: RemoteDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData).apply {
                        instance = this
                    }
                }
    }
    fun getNews(): LiveData<ArrayList<News>> = remoteDataSource.getNews()
}