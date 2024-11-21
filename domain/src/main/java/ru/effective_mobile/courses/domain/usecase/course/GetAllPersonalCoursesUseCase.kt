package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetAllPersonalCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}

internal class GetAllPersonalCoursesUseCaseImpl(
    private val courseRepository: CourseRepository
) : GetAllPersonalCoursesUseCase {
    override fun invoke() =
        courseRepository.getAllPersonalCourses()
}