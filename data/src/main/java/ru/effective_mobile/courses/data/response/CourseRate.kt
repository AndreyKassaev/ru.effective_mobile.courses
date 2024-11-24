package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Transient

@Serializable
data class CourseRate(
    @Transient @SerialName("meta") var meta: Meta? = Meta(),
    @SerialName("course-review-summaries") var courseReviewSummaries: ArrayList<CourseReviewSummaries> = arrayListOf()
)