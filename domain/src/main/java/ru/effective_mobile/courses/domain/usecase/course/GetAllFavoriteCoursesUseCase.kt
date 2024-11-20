package ru.effective_mobile.courses.domain.usecase.course

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.effective_mobile.courses.domain.model.Course

interface GetAllFavoriteCoursesUseCase {
    operator fun invoke(): Flow<List<Course>>
}

internal class GetAllFavoriteCoursesUseCaseImpl : GetAllFavoriteCoursesUseCase {
    override operator fun invoke() =
        flowOf(
            List(100) { Course.mock }
        )
}