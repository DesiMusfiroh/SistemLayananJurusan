package com.layanan.jurusan.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.layanan.jurusan.data.News
import com.layanan.jurusan.data.remote.api.ApiConfig
import com.layanan.jurusan.data.remote.response.ListNewsResponse
import com.layanan.jurusan.data.remote.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        fun getInstance(): RemoteDataSource {
            return RemoteDataSource()
        }
        private const val TAG = "Remote Data Source"
    }

    fun getUserLogin(username: String, password: String): LiveData<UserResponse> {
        val user: MutableLiveData<UserResponse> = MutableLiveData()
        val client = ApiConfig.getApiService().login(username, password)
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    user.postValue(response.body())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return user
    }

    fun getLatestNews(): LiveData<List<News>> {
        val results = MutableLiveData<List<News>>()
        ApiConfig.getApiService().getLatestNews().enqueue(object: Callback<ListNewsResponse> {
            override fun onResponse(call: Call<ListNewsResponse>, response: Response<ListNewsResponse>) {
                if (response.isSuccessful) {
                    results.postValue(response.body()?.news)
                    Log.e(TAG, "onSuccess: ${response.body()?.news}")
                } else {
                    Log.e(TAG, "onFailure Response: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ListNewsResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return results
    }
}