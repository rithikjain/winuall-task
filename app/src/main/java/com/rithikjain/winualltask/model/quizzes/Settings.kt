package com.rithikjain.winualltask.model.quizzes


import com.google.gson.annotations.SerializedName

data class Settings(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("isSuffle")
    val isSuffle: Boolean,
    @SerializedName("public")
    val `public`: Boolean,
    @SerializedName("security")
    val security: Boolean,
    @SerializedName("sendMessageToParents")
    val sendMessageToParents: Boolean,
    @SerializedName("sendMessageToStudent")
    val sendMessageToStudent: Boolean,
    @SerializedName("solutionReleaseAt")
    val solutionReleaseAt: Any,
    @SerializedName("solutionReleaseType")
    val solutionReleaseType: Int
)