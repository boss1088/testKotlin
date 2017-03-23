package com.bosovskyi.testkotlin.ui.adapters

import android.graphics.Bitmap
import android.support.v4.content.ContextCompat.*
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bosovskyi.testkotlin.R
import com.bosovskyi.testkotlin.domain.model.ShowListEntity
import com.bosovskyi.testkotlin.ui.utils.ctx
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.lang.Exception

import kotlinx.android.synthetic.main.item_show.view.*

/**
 * Created by boss1088 on 3/16/17.
 */
class ShowsAdapter(var shows : List<ShowListEntity>,
                   val itemClick: (ShowListEntity) -> Unit) :
        RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindShow(shows[position])
    }

    override fun getItemCount() = shows.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.item_show, parent, false)

        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, val itemClick: (ShowListEntity) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindShow(show: ShowListEntity) {
            with(show) {
                itemView.setOnClickListener { itemClick(this) }
                itemView.showName.text = name
                itemView.showRating.text = averageRating

                Glide.with(itemView.showCover.ctx)
                        .load(posterUrl)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .listener(object : RequestListener<String, Bitmap>{
                            override fun onException(e: Exception?, model: String?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                                return false
                            }

                            override fun onResourceReady(resource: Bitmap?, model: String?, target: Target<Bitmap>?, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
                                Palette.from(resource).generate {
                                    palette -> itemView.infoBackground
                                        .setBackgroundColor(
                                                palette!!.getLightMutedColor(getColor(itemView.infoBackground.ctx, android.R.color.white)))
                                }
                                return false
                            }

                        })
                        .into(itemView.showCover)
            }
        }
    }
}