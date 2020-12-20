package com.example.theair.data.network

import androidx.lifecycle.MutableLiveData
import com.example.theair.data.model.*
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

    fun getMovieDetails(id: Int?): MutableLiveData<MovieDetailResponse> {

        val data = MutableLiveData<MovieDetailResponse>()

        if (getAppService() != null) {
            getAppService()?.callGetMovieDetails(id)
                ?.enqueue(object : Callback<MovieDetailResponse?> {
                    override fun onResponse(
                        call: Call<MovieDetailResponse?>,
                        response: Response<MovieDetailResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null)
                            data.value = response.body()
                        else
                            data.value = null
                    }

                    override fun onFailure(call: Call<MovieDetailResponse?>, t: Throwable) {
                        data.value = null
                    }
                })
        }

        return data
    }

    fun getMovieCredits(id: Int?): MutableLiveData<MovieCreditsResponse> {

        val data = MutableLiveData<MovieCreditsResponse>()

        if (getAppService() != null) {
            getAppService()?.callGetMovieCredits(id)
                ?.enqueue(object : Callback<MovieCreditsResponse?> {
                    override fun onResponse(
                        call: Call<MovieCreditsResponse?>,
                        response: Response<MovieCreditsResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null)
                            data.value = response.body()
                        else
                            data.value = null
                    }

                    override fun onFailure(call: Call<MovieCreditsResponse?>, t: Throwable) {
                        data.value = null
                    }
                })
        }

        return data
    }

    fun getMovieRecommendations(id: Int?): MutableLiveData<MovieRecommendationsResponse> {

        val data = MutableLiveData<MovieRecommendationsResponse>()

        if (getAppService() != null) {
            getAppService()?.callGetMovieRecommendations(id)
                ?.enqueue(object : Callback<MovieRecommendationsResponse?> {
                    override fun onResponse(
                        call: Call<MovieRecommendationsResponse?>,
                        response: Response<MovieRecommendationsResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null)
                            data.value = response.body()
                        else
                            data.value = null
                    }

                    override fun onFailure(
                        call: Call<MovieRecommendationsResponse?>,
                        t: Throwable
                    ) {
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