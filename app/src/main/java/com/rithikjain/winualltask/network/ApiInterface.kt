package com.rithikjain.winualltask.network

import com.rithikjain.winualltask.model.questions.QuestionsResponse
import com.rithikjain.winualltask.model.quizzes.QuizzesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("b00b070fc2461a68383b")
    suspend fun getQuizzes(): Response<QuizzesResponse>

    @GET("c454bbb861f9ab1e9309")
    suspend fun getQuestions(): Response<QuestionsResponse>

}