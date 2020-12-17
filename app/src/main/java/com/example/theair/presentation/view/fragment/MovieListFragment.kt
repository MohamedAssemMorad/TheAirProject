package com.example.theair.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import com.example.theair.BaseFragment
import com.example.theair.R
import com.example.theair.presentation.viewmodel.MovieListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment() {

    //    private var postsList: ArrayList<PostsResult>? = null
    private val movieListViewModel: MovieListViewModel by viewModel()

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

    override fun onResume() {
        super.onResume()
    }

    private fun getMovieList() {
//        postsList?.clear()
//        pbLoader.visibility = View.VISIBLE
        movieListViewModel.callGetMovieList(1)
            .observe(this, Observer {
//                pbLoader.visibility = View.GONE

                if (it != null) {

//                    GlobalScope.launch {
//                        postsViewModel.callDeletePostsLocally()
//                        postsViewModel.savePosts(postsList!!)
//                    }
//                    adapterProcess()
                } else {
                    Toast.makeText(mContext, "", Toast.LENGTH_LONG).show()
                }
            })
    }

    companion object {
        val TAG: String = MovieListFragment::class.java.simpleName
    }
}