package com.rithikjain.winualltask.ui.questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.rithikjain.winualltask.R
import com.rithikjain.winualltask.model.Result
import com.rithikjain.winualltask.model.questions.Question
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_questions.*
import org.koin.android.viewmodel.ext.android.viewModel

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        questionMainView.isVisible = false
        prevButton.isEnabled = false
        nextButton.isEnabled = false
        imageFix()

        var questionNumber = 0

        val questionsViewModel by viewModel<QuestionsViewModel>()
        var questionList: MutableList<Question> = mutableListOf()

        questionsViewModel.questions.observe(this, Observer {
            when (it) {
                is Result.Success -> {
                    questionsProgress.isVisible = false
                    questionMainView.isVisible = true
                    prevButton.isEnabled = true
                    nextButton.isEnabled = true
                    questionList = it.data!!.questions.toMutableList()
                    setQuestionUI(questionNumber, questionList)
                }
                is Result.Error -> {
                    quizProgress.isVisible = false
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })

        nextButton.setOnClickListener {
            if (questionNumber < 149) {
                questionNumber++
                setQuestionUI(questionNumber, questionList)
            }
        }

        prevButton.setOnClickListener {
            if (questionNumber > 0) {
                questionNumber--
                setQuestionUI(questionNumber, questionList)
            }
        }
    }

    private fun setQuestionUI(position: Int, questions: List<Question>) {
        questionNumber.text = "${position+1}"
        questionView.loadData(questions[position].body, "text/html", "UTF-8")
        questionOneContent.loadData(questions[position].options[0].value, "text/html", "UTF-8")
        questionTwoContent.loadData(questions[position].options[1].value, "text/html", "UTF-8")
        questionThreeContent.loadData(questions[position].options[2].value, "text/html", "UTF-8")
        questionFourContent.loadData(questions[position].options[3].value, "text/html", "UTF-8")
    }

    private fun imageFix() {
        questionView.settings.apply {
            domStorageEnabled = true
            setAppCacheEnabled(true)
            loadsImagesAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        questionOneContent.settings.apply {
            domStorageEnabled = true
            setAppCacheEnabled(true)
            loadsImagesAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        questionTwoContent.settings.apply {
            domStorageEnabled = true
            setAppCacheEnabled(true)
            loadsImagesAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        questionThreeContent.settings.apply {
            domStorageEnabled = true
            setAppCacheEnabled(true)
            loadsImagesAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        questionFourContent.settings.apply {
            domStorageEnabled = true
            setAppCacheEnabled(true)
            loadsImagesAutomatically = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
    }
}