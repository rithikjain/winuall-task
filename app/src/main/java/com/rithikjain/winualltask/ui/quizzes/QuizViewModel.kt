package com.rithikjain.winualltask.ui.quizzes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rithikjain.winualltask.model.Result
import com.rithikjain.winualltask.model.quizzes.QuizzesResponse
import com.rithikjain.winualltask.repository.AppRepo

class QuizViewModel(repo: AppRepo) : ViewModel() {
    var quizzes: LiveData<Result<QuizzesResponse>> = repo.getQuizzes()
}