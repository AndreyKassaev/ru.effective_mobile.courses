package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.domain.repository.CourseRepository

interface GetAllAvailableCourseListFlowUseCase {
    operator fun invoke(): Flow<List<Course>>
}

class GetAllAvailableCourseListFlowUseCaseImpl(
    private val repository: CourseRepository
) : GetAllAvailableCourseListFlowUseCase {
    override fun invoke(): Flow<List<Course>> =
        repository.getAllAvailableCourseListFlow()

}