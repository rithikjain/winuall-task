package com.rithikjain.winualltask.model.questions


import com.google.gson.annotations.SerializedName

data class Chapter(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String
)