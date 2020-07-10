package com.rithikjain.winualltask.network

class ApiClient(private val api: ApiInterface) : BaseApiClient() {

    suspend fun getQuizzes() = getResult {
        api.getQuizzes()
    }

    suspend fun getQuestions() = getResult {
        api.getQuestions()
    }

}