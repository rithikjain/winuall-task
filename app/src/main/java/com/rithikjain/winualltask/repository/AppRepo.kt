package com.rithikjain.winualltask.repository

import com.rithikjain.winualltask.network.ApiClient

class AppRepo(private val apiClient: ApiClient) : BaseRepo() {

    fun getQuizzes() = makeRequest {
        apiClient.getQuizzes()
    }

    fun getQuestions() = makeRequest {
        apiClient.getQuestions()
    }

}