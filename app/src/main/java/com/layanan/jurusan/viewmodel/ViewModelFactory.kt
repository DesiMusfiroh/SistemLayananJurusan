package com.layanan.jurusan.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.layanan.jurusan.data.DataRepository
import com.layanan.jurusan.di.Injection
import com.layanan.jurusan.ui.home.HomeViewModel

class ViewModelFactory private constructor(private val dataRepository: DataRepository)
    : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(dataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}