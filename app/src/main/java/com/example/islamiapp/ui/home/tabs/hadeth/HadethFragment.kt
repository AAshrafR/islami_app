package com.example.islamiapp.ui.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadethBinding
import com.example.islamiapp.ui.Constants
import com.example.islamiapp.ui.home.model.Hadeth
import com.example.islamiapp.ui.home.tabs.hadethDetails.HadethDetailsActivity


class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding

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
        initViews()
    }

    lateinit var adapter: HadethRecyclerAdapter
    private fun initViews() {
        adapter = HadethRecyclerAdapter(null)
        adapter.onItemClickListener =
            HadethRecyclerAdapter.OnItemClickListener { position, hadeth ->
                showHadethDetails(hadeth)

            }
        viewBinding.rvHadeth.adapter = adapter
    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItem(hadethList)
    }

    val hadethList = mutableListOf<Hadeth>()

    private fun loadHadethFile() {
        val fileContent = requireActivity().assets.open("ahadeth.txt")
            .bufferedReader().use { it.readText() }
        val singleHadeth = fileContent.trim().split("#")

        singleHadeth.forEach { element ->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")

            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
    }
}