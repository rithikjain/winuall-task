package com.rithikjain.winualltask.ui.quizzes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.adapter.UpcomingRecyclerViewAdapter
import com.rithikjain.winualltask.model.Result
import kotlinx.android.synthetic.main.fragment_upcoming.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class UpcomingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val upcomingAdapter = UpcomingRecyclerViewAdapter()
        upcomingRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = upcomingAdapter
        }

        nothingText.isVisible = false

        val quizViewModel by sharedViewModel<QuizViewModel>()

        quizViewModel.quizzes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    if (it.data!!.batch.upcoming.isNotEmpty()) {
                        upcomingAdapter.setList(it.data.batch.ongoing)
                    } else {
                        nothingText.isVisible = true
                    }
                }
            }
        })
    }
}