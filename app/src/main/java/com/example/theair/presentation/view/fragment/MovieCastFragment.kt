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
import com.example.theair.data.model.CastResponse
import com.example.theair.data.model.MovieDetailResponse
import com.example.theair.data.model.MovieResultsResponse
import com.example.theair.data.network.RetrofitHelper
import com.example.theair.presentation.view.adapter.MovieCastAdapter
import com.example.theair.presentation.view.adapter.MovieListAdapter
import com.example.theair.presentation.viewmodel.MovieCreditsViewModel
import com.example.theair.presentation.viewmodel.MovieDetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_cast.*
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.fragment_movie_details.pbLoader
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieCastFragment : BaseFragment() {

    private var moviesCast: ArrayList<CastResponse>? = ArrayList()
    private var movieCastAdapter: MovieCastAdapter? = null
    private val movieCastViewModel: MovieCreditsViewModel by viewModel()
    private var movieId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchBundle(arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        inflater.inflate(R.layout.fragment_movie_cast, contentContainer, true)
        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieCast()
    }

    override fun onResume() {
        super.onResume()
        toolbarProcess()
    }

    private fun getMovieCast() {
        moviesCast?.clear()
        pbLoader.visibility = View.VISIBLE
        movieCastViewModel.callGetMovieCredits(movieId ?: 0)
            .observe(this, Observer {
                pbLoader.visibility = View.GONE
                if (!it?.cast.isNullOrEmpty()) {
                    moviesCast = it?.cast
                    adapterProcess()
                } else {
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun adapterProcess() {
        movieCastAdapter = MovieCastAdapter(
            mContext,
            moviesCast
        )
        rvMovieCast?.adapter = movieCastAdapter
    }

    private fun fetchBundle(arguments: Bundle?) {
        movieId = arguments?.getInt(MOVIE_DETAILS)
    }

    companion object {
        val TAG: String = MovieCastFragment::class.java.simpleName
        private const val MOVIE_DETAILS = "movie_details"

        fun newInstance(
            movieId: Int?
        ) = run {
            val fragment =
                MovieCastFragment()
            fragment.arguments = bundleOf(
                MOVIE_DETAILS to movieId
            )
            return@run fragment
        }
    }
}