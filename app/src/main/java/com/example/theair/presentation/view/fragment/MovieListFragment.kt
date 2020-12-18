package com.example.theair.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.theair.BaseFragment
import com.example.theair.R
import com.example.theair.core.utils.FragmentUtil
import com.example.theair.data.model.MovieResultsResponse
import com.example.theair.presentation.view.adapter.MovieListAdapter
import com.example.theair.presentation.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment() {

    private var moviesList: ArrayList<MovieResultsResponse>? = null
    private val movieListViewModel: MovieListViewModel by viewModel()
    private var movieListAdapter: MovieListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        inflater.inflate(R.layout.fragment_movie_list, contentContainer, true)
        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovieList()
    }

    private fun adapterProcess() {
        movieListAdapter = MovieListAdapter(
            mContext,
            moviesList,
            onItemClicked = { resultsItem: MovieResultsResponse? ->
//                FragmentUtil.replaceFragment(
//                    activity as AppCompatActivity,
//                    CaseRequestDetailsFragment.newInstance(resultsItem?.RequestID),
//                    true,
//                    TAG = CaseRequestDetailsFragment.TAG
//                )
            })
        rvMoviesList?.adapter = movieListAdapter
    }

    private fun getMovieList() {
        moviesList?.clear()
        pbLoader.visibility = View.VISIBLE
        movieListViewModel.callGetMovieList(1, 1, "vote_average.desc")
            .observe(this, Observer {
                pbLoader.visibility = View.GONE
                if (!it?.results.isNullOrEmpty()) {

                    moviesList = it?.results!!
//                    GlobalScope.launch {
//                        postsViewModel.callDeletePostsLocally()
//                        postsViewModel.savePosts(postsList!!)
//                    }
                    adapterProcess()
                } else {
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
    }

    companion object {
        val TAG: String = MovieListFragment::class.java.simpleName
    }
}