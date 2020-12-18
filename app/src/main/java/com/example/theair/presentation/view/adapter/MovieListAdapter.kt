package com.example.theair.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theair.R
import com.example.theair.data.model.MovieResultsResponse
import com.example.theair.data.network.RetrofitHelper
import com.squareup.picasso.Picasso

class MovieListAdapter(
    val context: Context,
    private val movieList: ArrayList<MovieResultsResponse>?,
    val onItemClicked: (movieResponse: MovieResultsResponse?) -> Unit
) :
    RecyclerView.Adapter<MovieListAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(movieList?.get(position))

        holder.itemView.setOnClickListener {
            onItemClicked(movieList?.get(position))
        }
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MovieResultsResponse?) {

            val movieTitle: AppCompatTextView = itemView.findViewById(R.id.tvTitle)
            val movieDate: AppCompatTextView = itemView.findViewById(R.id.tvDate)
            val movieVoting: AppCompatTextView = itemView.findViewById(R.id.tvVote)
            val moviePoster: AppCompatImageView = itemView.findViewById(R.id.ivPoster)

            movieTitle.text = item?.title
            movieDate.text = item?.release_date
            movieVoting.text = item?.vote_average.toString()
            Picasso.with(context).load(RetrofitHelper.IMAGE_BASE_URL + item?.poster_path)
                .into(moviePoster)
        }
    }

    companion object {
        val TAG: String = MovieListAdapter::class.java.simpleName
    }
}