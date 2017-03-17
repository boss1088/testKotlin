package com.bosovskyi.testkotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.bosovskyi.testkotlin.domain.model.ShowListEntity

/**
 * Created by boss1088 on 3/16/17.
 */
class ShowsAdapter(val shows : List<ShowListEntity>) : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(shows[position]) {
            holder.textView.text = "$name - $averageRating"
        }
    }

    override fun getItemCount(): Int = shows.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}