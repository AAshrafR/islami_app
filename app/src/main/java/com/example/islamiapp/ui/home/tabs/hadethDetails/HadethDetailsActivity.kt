package com.example.islamiapp.ui.home.tabs.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityHadethDetailsBinding
import com.example.islamiapp.ui.Constants
import com.example.islamiapp.ui.home.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        bindHadeth()
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.titleTv.text = hadeth?.title
        viewBinding.hadethContent.contentHadethDetails.text = hadeth?.content
    }

    var hadeth: Hadeth? = null
    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(
                Constants.EXTRA_HADETH, Hadeth::class.java
            )
        } else {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH) as Hadeth?
        }
    }
}