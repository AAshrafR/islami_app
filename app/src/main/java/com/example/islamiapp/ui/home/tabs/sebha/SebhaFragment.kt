package com.example.islamiapp.ui.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        initFragmentSebha()
        return viewBinding.root
    }

    private fun initFragmentSebha() {
        var count: Int = 0
        viewBinding.btnWerd.setOnClickListener {
            if (count < 100) {
                count += 1
                viewBinding.tasbehCountTv.setText(count.toString())
                viewBinding.bodySebha.rotation += (360 / 33f)
            } else {
                count = 1
                viewBinding.tasbehCountTv.setText(count.toString())
                viewBinding.bodySebha.rotation -= (360 / 33f)
            }
        }
    }
}
