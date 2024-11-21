package ru.effective_mobile.courses.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course

interface CourseRepository {

    fun getAllAvailableCourses(): Flow<List<Course>>

    fun getAllFavoriteCourses(): Flow<List<Course>>

    fun getAllPersonalCourses(): Flow<List<Course>>

    fun getCourseDetail(courseId: String?): Flow<Course>
}