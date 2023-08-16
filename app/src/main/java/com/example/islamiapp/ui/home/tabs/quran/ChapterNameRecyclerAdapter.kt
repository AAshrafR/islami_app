package com.example.islamiapp.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemChapterNameBinding

class ChapterNameRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<ChapterNameRecyclerAdapter.ViewHolder>() {

    lateinit var viewBinding: ItemChapterNameBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.viewBinding.title.text = names[position]

        if (onItemClickListener != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickListener?.onItemClick(position, names[position])
            }
        }

    }

    override fun getItemCount(): Int = names.size

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }

    class ViewHolder(val viewBinding: ItemChapterNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}