package ru.effective_mobile.courses.domain.usecase.course

import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetAllAvailableCourseListUseCase {
    suspend operator fun invoke()
}

internal class GetAllAvailableCourseListUseCaseImpl(
    private val courseRepository: CourseRepository
) : GetAllAvailableCourseListUseCase {
    override suspend operator fun invoke() {
        courseRepository.getAllAvailableCourseList()
    }
}