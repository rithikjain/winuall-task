package com.rithikjain.winualltask.model.questions

import com.google.gson.annotations.SerializedName

data class QuestionsResponse (
    @SerializedName("data")
    val questions: List<Question>
)