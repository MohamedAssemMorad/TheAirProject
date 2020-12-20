package com.example.theair.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.example.theair.BaseFragment
import com.example.theair.R
import com.example.theair.core.utils.FragmentUtil
import com.example.theair.data.model.MovieResultsResponse
import com.example.theair.presentation.view.adapter.MovieRecommendationsAdapter
import com.example.theair.presentation.viewmodel.MovieRecommendationsViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.pbLoader
import kotlinx.android.synthetic.main.fragment_movie_recommendations.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieRecommendationsFragment : BaseFragment() {

    private var moviesRecommendations: ArrayList<MovieResultsResponse>? = null
    private val movieRecommendationsViewModel: MovieRecommendationsViewModel by viewModel()
    private var movieListAdapter: MovieRecommendationsAdapter? = null
    private var movieId: Int? = 315635

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        inflater.inflate(R.layout.fragment_movie_recommendations, contentContainer, true)
        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieRecommendations()
    }

    override fun onResume() {
        super.onResume()
        toolbarProcess()
    }

    override fun toolbarProcess() {
        super.toolbarProcess()
        toolbar.hideBackIcon(activity as AppCompatActivity)
    }

    private fun adapterProcess() {
        movieListAdapter = MovieRecommendationsAdapter(
            mContext,
            moviesRecommendations,
            onItemClicked = { resultsItem: MovieResultsResponse? ->
                FragmentUtil.replaceFragment(
                    activity as AppCompatActivity,
                    MovieDetailsFragment.newInstance(resultsItem?.id),
                    true,
                    TAG = MovieDetailsFragment.TAG
                )
            })
        rvMoviesRecommendations?.adapter = movieListAdapter
    }

    private fun getMovieRecommendations() {
        moviesRecommendations?.clear()
        pbLoaderRecomm.visibility = View.VISIBLE
        movieRecommendationsViewModel.callGetMovieRecommendations(movieId!!)
            .observe(this, Observer {
                pbLoaderRecomm.visibility = View.GONE
                if (!it?.results.isNullOrEmpty()) {
                    moviesRecommendations = it?.results!!
                    adapterProcess()
                } else {
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
    }

    companion object {
        val TAG: String = MovieRecommendationsFragment::class.java.simpleName
    }
}