package com.rithikjain.winualltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.rithikjain.winualltask.adapter.AppStateAdapter
import com.rithikjain.winualltask.model.Result
import com.rithikjain.winualltask.ui.quizzes.QuizViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizViewModel by viewModel<QuizViewModel>()

        quizViewModel.quizzes.observe(this, Observer {
            when (it) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    quizProgress.isVisible = false
                    initViewPager()

                }
                is Result.Error -> {
                    quizProgress.isVisible = false
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initViewPager() {
        val adapter = AppStateAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val tabNames = listOf("Ongoing", "Upcoming", "Completed")
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}