package com.rithikjain.winualltask.model.questions


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("body")
    val body: String,
    @SerializedName("chapter")
    val chapter: Chapter,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("difficulty")
    val difficulty: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isMultiple")
    val isMultiple: Boolean,
    @SerializedName("isPassage")
    val isPassage: Boolean,
    @SerializedName("negativeMarks")
    val negativeMarks: Int,
    @SerializedName("options")
    val options: List<Option>,
    @SerializedName("orgId")
    val orgId: String,
    @SerializedName("partialMarks")
    val partialMarks: Int,
    @SerializedName("positiveMarks")
    val positiveMarks: Int,
    @SerializedName("questionType")
    val questionType: String,
    @SerializedName("solution")
    val solution: String,
    @SerializedName("subject")
    val subject: Subject,
    @SerializedName("subtopics")
    val subtopics: List<Any>
)