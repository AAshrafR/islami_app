package com.example.islamiapp.ui.home.tabs.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    var names = listOf(
        "hadeth1",
        "hadeth2",
        "hadeth3",
        "hadeth4",
        "hadeth5",
        "hadeth6",
        "hadeth7",
        "hadeth8",
        "hadeth9",
        "hadeth10",
        "hadeth11",
        "hadeth12",
        "hadeth13",
        "hadeth14",
        "hadeth15",
        "hadeth16",
        "hadeth17",
        "hadeth18",
        "hadeth19",
        "hadeth20",
        "hadeth21",
        "hadeth22",
        "hadeth23",
        "hadeth24",
        "hadeth25",
        "hadeth26",
        "hadeth27",
        "hadeth28",
        "hadeth29",
        "hadeth30",
        "hadeth31",
        "hadeth32",
        "hadeth33",
        "hadeth34",
        "hadeth35",
        "hadeth36",
        "hadeth37",
        "hadeth38",
        "hadeth39",
        "hadeth40",
        "hadeth41",
        "hadeth42",
        "hadeth43",
        "hadeth44",
        "hadeth45",
        "hadeth46",
        "hadeth47",
        "hadeth48",
        "hadeth49",
        "hadeth50",
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    lateinit var adapter: HadethNameRecyclerAdapter

    private fun initRecyclerView() {
        adapter = HadethNameRecyclerAdapter(names)
        adapter.onItemClickListener = object : HadethNameRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, name: String) {
            }
        }
        viewBinding.rvHadeth.adapter = adapter
    }
}