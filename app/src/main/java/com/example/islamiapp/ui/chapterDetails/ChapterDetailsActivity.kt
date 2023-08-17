package com.example.islamiapp.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityChapterDetailsBinding
import com.example.islamiapp.ui.Constants

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        initViews()
        loadChapterFile()

    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewBinding.titleTv.text = chapterName
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun loadChapterFile() {
        val fileContent = assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        bindVerses(lines)
    }

    lateinit var adapter: VersesAdapter

    private fun bindVerses(verses: List<String>) {

        adapter = VersesAdapter(verses)
        viewBinding.chapterContent.vercesRecyclerView.adapter = adapter

    }

    lateinit var chapterName: String
    var chapterIndex: Int = 0
    private fun initParams() {
        chapterName = intent.getStringExtra(Constants.EXTRA_NAME) ?: ""
        chapterIndex = intent.getIntExtra(Constants.EXTRA_INDEX, 0)

    }
}