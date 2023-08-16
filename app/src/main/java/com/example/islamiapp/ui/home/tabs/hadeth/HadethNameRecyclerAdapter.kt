package com.example.islamiapp.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemHadethNameBinding

class HadethNameRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<HadethNameRecyclerAdapter.ViewHolder>() {

    lateinit var viewBinding: ItemHadethNameBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemHadethNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    class ViewHolder(val viewBinding: ItemHadethNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}