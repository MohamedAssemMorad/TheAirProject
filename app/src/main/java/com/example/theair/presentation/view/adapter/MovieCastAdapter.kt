package com.example.theair.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theair.R
import com.example.theair.data.model.CastResponse
import com.example.theair.data.network.RetrofitHelper
import com.squareup.picasso.Picasso

class MovieCastAdapter(
    val context: Context,
    private val castList: ArrayList<CastResponse>?
) :
    RecyclerView.Adapter<MovieCastAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return castList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(castList?.get(position))
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CastResponse?) {

            val name: AppCompatTextView = itemView.findViewById(R.id.tvTitle)
            val character: AppCompatTextView = itemView.findViewById(R.id.tvDate)
            val movieVoting: AppCompatTextView = itemView.findViewById(R.id.tvVote)
            val image: AppCompatImageView = itemView.findViewById(R.id.ivPoster)

            name.text = item?.name
            character.text = item?.character
            movieVoting.visibility = View.GONE
            Picasso.with(context).load(RetrofitHelper.IMAGE_BASE_URL + item?.profile_path)
                .into(image)
        }
    }

    companion object {
        val TAG: String = MovieCastAdapter::class.java.simpleName
    }
}