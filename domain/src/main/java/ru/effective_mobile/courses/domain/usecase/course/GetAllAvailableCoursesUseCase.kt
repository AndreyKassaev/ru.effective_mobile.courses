package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetAllAvailableCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}

internal class GetAllAvailableCoursesUseCaseImpl(
    private val courseRepository: CourseRepository
) : GetAllAvailableCoursesUseCase {
    override operator fun invoke() =
        courseRepository.getAllAvailableCourses()

}