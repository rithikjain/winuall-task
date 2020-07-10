package com.rithikjain.winualltask.ui.quizzes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.adapter.CompletedRecyclerViewAdapter
import com.rithikjain.winualltask.model.Result
import kotlinx.android.synthetic.main.fragment_completed.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CompletedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val completedAdapter = CompletedRecyclerViewAdapter()
        completedRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = completedAdapter
        }

        val quizViewModel by sharedViewModel<QuizViewModel>()

        quizViewModel.quizzes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    completedAdapter.setList(it.data!!.batch.completed)
                }
            }
        })
    }
}