package com.example.islamiapp.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemHadethBinding
import com.example.islamiapp.ui.home.model.Hadeth

class HadethRecyclerAdapter(private var items: List<Hadeth>?) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    lateinit var viewBinding: ItemHadethBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.hadethNameTv.text = items!![position].title
        if (onItemClickListener != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickListener?.onItemClick(position, items!![position])
            }
        }
    }


    override fun getItemCount(): Int = items?.size ?: 0

    fun bindItem(newList: List<Hadeth>) {
        items = newList
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, item: Hadeth)
    }

    class ViewHolder(val viewBinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}