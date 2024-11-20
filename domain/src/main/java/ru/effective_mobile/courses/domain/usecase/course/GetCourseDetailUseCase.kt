package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.effective_mobile.courses.domain.model.Course

interface GetCourseDetailUseCase {
    operator fun invoke(courseId: String?): Flow<Course>
}

internal class GetCourseDetailUseCaseImpl : GetCourseDetailUseCase {
    override operator fun invoke(courseId: String?) =
        flowOf(
            Course.mock
        )
}