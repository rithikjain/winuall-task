package com.rithikjain.winualltask.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rithikjain.winualltask.model.Result
import com.rithikjain.winualltask.model.questions.QuestionsResponse
import com.rithikjain.winualltask.repository.AppRepo

class QuestionsViewModel(repo: AppRepo) : ViewModel() {
    var questions: LiveData<Result<QuestionsResponse>> = repo.getQuestions()
}