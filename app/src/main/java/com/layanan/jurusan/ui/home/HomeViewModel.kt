package com.layanan.jurusan.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.layanan.jurusan.data.DataRepository
import com.layanan.jurusan.data.News

class HomeViewModel(private val repository: DataRepository) : ViewModel() {
    fun getNews() : LiveData<ArrayList<News>> = repository.getNews()
}