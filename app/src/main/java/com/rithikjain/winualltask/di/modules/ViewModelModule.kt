package com.rithikjain.winualltask.di.modules

import com.rithikjain.winualltask.ui.questions.QuestionsViewModel
import com.rithikjain.winualltask.ui.quizzes.QuizViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizViewModel(get()) }
    viewModel { QuestionsViewModel(get()) }
}