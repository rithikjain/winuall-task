package com.rithikjain.winualltask.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.model.quizzes.Ongoing
import com.rithikjain.winualltask.ui.questions.QuestionsActivity
import kotlinx.android.synthetic.main.quiz_info_item.view.*

class OngoingRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<OngoingRecyclerViewAdapter.OngoingViewHolder>() {

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

        holder.itemView.startButton.setOnClickListener {
            val intent = Intent(context, QuestionsActivity::class.java)
            context.startActivity(intent)
        }
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