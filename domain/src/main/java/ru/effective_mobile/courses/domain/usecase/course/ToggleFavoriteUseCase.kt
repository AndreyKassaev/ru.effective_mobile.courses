package ru.effective_mobile.courses.domain.usecase.course

import ru.effective_mobile.courses.domain.repository.CourseRepository

interface ToggleFavoriteUseCase {
    suspend operator fun invoke(courseId: String)
}

class ToggleFavoriteUseCaseImpl(
    private val courseRepository: CourseRepository
) : ToggleFavoriteUseCase {
    override suspend operator fun invoke(courseId: String) {
        courseRepository.toggleFavorite(courseId = courseId)
    }


}

