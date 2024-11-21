package ru.effective_mobile.courses.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.effective_mobile.courses.data.model.CourseMapper.mapToDomainCourse
import ru.effective_mobile.courses.domain.repository.CourseRepository
import ru.effective_mobile.courses.data.model.Course as DataCourse
import ru.effective_mobile.courses.domain.model.Course as DomainCourse

class CourseRepositoryImpl : CourseRepository {
    override fun getAllAvailableCourses(): Flow<List<DomainCourse>> =
        flowOf(
            List(100) { mapToDomainCourse(DataCourse.mock) }
        )

    override fun getAllFavoriteCourses(): Flow<List<DomainCourse>> =
        flowOf(
            List(100) { mapToDomainCourse(DataCourse.mock) }
        )

    override fun getAllPersonalCourses(): Flow<List<DomainCourse>> =
        flowOf(
            List(100) { mapToDomainCourse(DataCourse.mock) }
        )

    override fun getCourseDetail(courseId: String?): Flow<DomainCourse> =
        flowOf(
            mapToDomainCourse(DataCourse.mock)
        )
}