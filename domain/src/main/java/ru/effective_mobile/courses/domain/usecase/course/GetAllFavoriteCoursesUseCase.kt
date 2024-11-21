package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetAllFavoriteCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}

internal class GetAllFavoriteCoursesUseCaseImpl(
    private val courseRepository: CourseRepository
) : GetAllFavoriteCoursesUseCase {
    override operator fun invoke() =
        courseRepository.getAllFavoriteCourses()
}