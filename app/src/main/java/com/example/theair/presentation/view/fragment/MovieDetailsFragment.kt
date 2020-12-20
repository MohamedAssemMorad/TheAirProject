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
import com.example.theair.data.model.MovieDetailResponse
import com.example.theair.data.network.RetrofitHelper
import com.example.theair.presentation.viewmodel.MovieDetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : BaseFragment() {

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()
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
        inflater.inflate(R.layout.fragment_movie_details, contentContainer, true)
        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieDetails()
        tvCast.setOnClickListener {
            FragmentUtil.replaceFragment(
                activity as AppCompatActivity,
                MovieCastFragment.newInstance(movieId),
                true,
                TAG = MovieCastFragment.TAG
            )
        }
    }

    override fun onResume() {
        super.onResume()
        toolbarProcess()
    }

    // get movie details by movieId
    private fun getMovieDetails() {
        pbLoader.visibility = View.VISIBLE
        movieDetailsViewModel.callGetMovieDetails(movieId ?: 0)
            .observe(this, Observer {
                pbLoader.visibility = View.GONE
                if (it?.success == true) {
                    setAllData(it)
                } else {
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun fetchBundle(arguments: Bundle?) {
        movieId = arguments?.getInt(MOVIE_DETAILS)
    }

    // set data for movie details screen for selected movie from list screen
    private fun setAllData(movieDetail: MovieDetailResponse) {

        tvTitleDetail.text = movieDetail?.title
        tvOverviewDetail.text = movieDetail?.overview
        tvRatingDetail.text = movieDetail?.vote_average.toString()
        tvGenreDetail.text =
            movieDetail?.genres?.get(0)?.name + ", " + movieDetail?.genres?.get(1)?.name
        Picasso.with(mContext)
            .load(RetrofitHelper.IMAGE_BASE_URL + movieDetail?.poster_path)
            .into(ivPosterImage)
    }


    companion object {
        val TAG: String = MovieDetailsFragment::class.java.simpleName
        private const val MOVIE_DETAILS = "movie_details"

        fun newInstance(
            movieId: Int?
        ) = run {
            val fragment =
                MovieDetailsFragment()
            fragment.arguments = bundleOf(
                MovieDetailsFragment.MOVIE_DETAILS to movieId
            )
            return@run fragment
        }
    }
}
