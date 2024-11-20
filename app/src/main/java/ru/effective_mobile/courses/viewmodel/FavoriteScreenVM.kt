package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.ViewModel
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCase

internal class FavoriteScreenVM(
    private val getAllFavoriteCoursesUseCase: GetAllFavoriteCoursesUseCase
) : ViewModel() {

    fun getCourseListFlow() = getAllFavoriteCoursesUseCase()

}