package com.rithikjain.winualltask.ui.quizzes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.adapter.OngoingRecyclerViewAdapter
import com.rithikjain.winualltask.model.Result
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_ongoing.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class OngoingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ongoing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ongoingAdapter = OngoingRecyclerViewAdapter(requireContext())
        ongoingRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = ongoingAdapter
        }

        val quizViewModel by sharedViewModel<QuizViewModel>()

        quizViewModel.quizzes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    ongoingAdapter.setList(it.data!!.batch.ongoing)
                }
            }
        })
    }
}