package com.example.theair.data.network

import androidx.lifecycle.MutableLiveData
import com.example.theair.data.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieAPIController {

    fun getMovieList(id: Int?, pageNum: Int, sortBy: String): MutableLiveData<MovieResponse> {

        val data = MutableLiveData<MovieResponse>()

        if (getAppService() != null) {
            getAppService()?.callGetMovieList(id, pageNum, sortBy)
                ?.enqueue(object : Callback<MovieResponse?> {
                    override fun onResponse(
                        call: Call<MovieResponse?>,
                        response: Response<MovieResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null)
                            data.value = response.body()
                        else
                            data.value = null
                    }

                    override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                        data.value = null
                    }
                })
        }

        return data
    }

    private fun getAppService(): RetrofitService? {
        return RetrofitHelper.getInstance()
    }
}