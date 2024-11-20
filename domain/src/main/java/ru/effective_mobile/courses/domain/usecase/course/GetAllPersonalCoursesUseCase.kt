package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.effective_mobile.courses.domain.model.Course

interface GetAllPersonalCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}

internal class GetAllPersonalCoursesUseCaseImpl : GetAllPersonalCoursesUseCase {
    override fun invoke() =
        flowOf(
            List(100) { Course.mock }
        )
}