package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class CourseList(

    @SerialName("meta") var meta: Meta? = Meta(),
    @SerialName("courses") var courses: ArrayList<Course> = arrayListOf(),
    @SerialName("enrollments") var enrollments: ArrayList<String> = arrayListOf()

)