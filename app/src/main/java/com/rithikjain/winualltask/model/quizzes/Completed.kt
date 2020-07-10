package com.rithikjain.winualltask.model.quizzes


import com.google.gson.annotations.SerializedName

data class Completed(
    @SerializedName("deletedAt")
    val deletedAt: Any,
    @SerializedName("quizDetails")
    val quizDetails: List<QuizDetail>,
    @SerializedName("scheduleEnd")
    val scheduleEnd: String,
    @SerializedName("scheduleStart")
    val scheduleStart: String
)