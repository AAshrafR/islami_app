package com.example.islamiapp.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.ui.home.tabs.hadeth.HadethFragment
import com.example.islamiapp.ui.home.tabs.quran.QuranFragment
import com.example.islamiapp.ui.home.tabs.radio.RadioFragment
import com.example.islamiapp.ui.home.tabs.sebha.SebhaFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content.bottomNav.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when (item.itemId) {

                    R.id.navigation_quran -> {
                        showTabFragment(QuranFragment())
                    }

                    R.id.navigation_hadeth -> {
                        showTabFragment(HadethFragment())
                    }

                    R.id.navigation_sebha -> {
                        showTabFragment(SebhaFragment())
                    }

                    R.id.navigation_radio -> {
                        showTabFragment(RadioFragment())
                    }
                }
                return true
            }
        })

        viewBinding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }

    private fun showTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }
}