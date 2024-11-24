package ru.effective_mobile.courses.data.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay

class ApiService {

    private val client = HttpClient(CIO)

    suspend fun getJsonStringAllCourseList(currentPage: Int): String {
        try {
            val uriCourseList =
                "https://stepik.org/api/courses?order=create_date&page=${currentPage}"
            val response = client.get(uriCourseList)
                .bodyAsText()
            return response
        } catch (e: Exception) {
            delay(1001)
            return getJsonStringAllCourseList(currentPage = currentPage)
        }
    }

    suspend fun getJsonStringCourse(courseId: String): String {
        try {
            val uriCourseDetail = "https://stepik.org/api/courses/$courseId"
            return client.get(uriCourseDetail)
                .bodyAsText()
        } catch (e: Exception) {
            delay(1001)
            return getJsonStringCourse(courseId = courseId)
        }
    }

    suspend fun getJsonStringCourseRate(courseId: String): String {
        try {
            val urlRate = "https://stepik.org/api/course-review-summaries?course=$courseId"
            return client.get(urlRate)
                .bodyAsText()
        } catch (e: Exception) {
            delay(1001)
            return getJsonStringCourseRate(courseId = courseId)
        }
    }
}