package com.rithikjain.winualltask.model.questions


import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("correct")
    val correct: Boolean,
    @SerializedName("_id")
    val id: String,
    @SerializedName("value")
    val value: String
)