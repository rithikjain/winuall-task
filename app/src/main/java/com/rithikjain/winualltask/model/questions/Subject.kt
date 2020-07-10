package com.rithikjain.winualltask.model.questions


import com.google.gson.annotations.SerializedName

data class Subject(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String
)