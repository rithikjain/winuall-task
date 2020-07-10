package com.rithikjain.winualltask.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rithikjain.winualltask.ui.quizzes.CompletedFragment
import com.rithikjain.winualltask.ui.quizzes.OngoingFragment
import com.rithikjain.winualltask.ui.quizzes.UpcomingFragment

class AppStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = arrayListOf(
        OngoingFragment(),
        UpcomingFragment(),
        CompletedFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}