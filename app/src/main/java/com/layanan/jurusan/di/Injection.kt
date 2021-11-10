package com.layanan.jurusan.di

import android.content.Context
import com.layanan.jurusan.data.DataRepository
import com.layanan.jurusan.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return DataRepository.getInstance(remoteDataSource)
    }
}