package ru.effective_mobile.courses.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course

interface CourseRepository {

    suspend fun getAllAvailableCourseList()

    fun getAllFavoriteCourses(): Flow<List<Course>>

    fun getAllPersonalCourses(): Flow<List<Course>>

    fun getCourseDetail(courseId: String): Flow<Course>

    suspend fun toggleFavorite(courseId: String)

    fun getAllAvailableCourseListFlow(): Flow<List<Course>>
}