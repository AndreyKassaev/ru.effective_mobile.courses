package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CourseReviewSummaries(

    @SerialName("id") var id: Int? = null,
    @SerialName("course") var course: Int? = null,
    @SerialName("average") var average: Double? = null,
    @SerialName("count") var count: Int? = null,
    @SerialName("distribution") var distribution: ArrayList<Int> = arrayListOf()

)