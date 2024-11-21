package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetCourseDetailUseCase {
    operator fun invoke(courseId: String?): Flow<Course>
}

internal class GetCourseDetailUseCaseImpl(
    private val courseRepository: CourseRepository
) : GetCourseDetailUseCase {
    override operator fun invoke(courseId: String?) =
        courseRepository.getCourseDetail(courseId = courseId)
}