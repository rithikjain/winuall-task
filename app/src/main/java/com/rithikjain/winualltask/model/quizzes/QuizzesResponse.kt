package com.rithikjain.winualltask.model.quizzes


import com.google.gson.annotations.SerializedName

data class QuizzesResponse(
    @SerializedName("batch")
    val batch: Batch
)