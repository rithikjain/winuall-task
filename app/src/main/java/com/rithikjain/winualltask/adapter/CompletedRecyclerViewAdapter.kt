package com.rithikjain.winualltask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.model.quizzes.Completed
import kotlinx.android.synthetic.main.quiz_info_item.view.*

class CompletedRecyclerViewAdapter :
    RecyclerView.Adapter<CompletedRecyclerViewAdapter.OngoingViewHolder>() {

    private var list: List<Completed> = listOf()

    fun setList(newList: List<Completed>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OngoingViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.quiz_info_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: OngoingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class OngoingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val quizName = view.quizName
        private val quizDuration = view.quizDuration
        private val quizTime = view.quizTime

        fun bind(quiz: Completed) {
            if (quiz.quizDetails.isNotEmpty()) {
                quizName.text = quiz.quizDetails[0].name
                quizDuration.text = "${quiz.quizDetails[0].duration} mins"
                quizTime.text = "${quiz.scheduleStart}-${quiz.scheduleEnd}"
            } else {
                quizName.text = "Null"
                quizDuration.text = "Null"
            }
        }
    }
}