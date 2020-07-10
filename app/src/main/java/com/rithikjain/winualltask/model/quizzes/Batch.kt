package com.rithikjain.winualltask.model.quizzes


import com.google.gson.annotations.SerializedName

data class Batch(
    @SerializedName("completed")
    val completed: List<Completed>,
    @SerializedName("ongoing")
    val ongoing: List<Ongoing>,
    @SerializedName("upcoming")
    val upcoming: List<Any>
)