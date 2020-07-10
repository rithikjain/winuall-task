package com.rithikjain.winualltask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.model.quizzes.Ongoing
import kotlinx.android.synthetic.main.quiz_info_item.view.*

class UpcomingRecyclerViewAdapter :
    RecyclerView.Adapter<UpcomingRecyclerViewAdapter.OngoingViewHolder>() {

    private var list: List<Ongoing> = listOf()

    fun setList(newList: List<Ongoing>) {
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

        fun bind(quiz: Ongoing) {
            quizName.text = quiz.quizDetails[0].name
            quizDuration.text = "${quiz.quizDetails[0].duration} mins"
            quizTime.text = "${quiz.scheduleStart}-${quiz.scheduleEnd}"
        }
    }
}