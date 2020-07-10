package com.rithikjain.winualltask.model.quizzes


import com.google.gson.annotations.SerializedName

data class QuizDetail(
    @SerializedName("courseId")
    val courseId: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("createdBy")
    val createdBy: String,
    @SerializedName("deletedAt")
    val deletedAt: Any,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("instructions")
    val instructions: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("orgId")
    val orgId: String,
    @SerializedName("published")
    val published: Boolean,
    @SerializedName("quizMarks")
    val quizMarks: Int,
    @SerializedName("quizType")
    val quizType: Int,
    @SerializedName("settings")
    val settings: Settings,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)