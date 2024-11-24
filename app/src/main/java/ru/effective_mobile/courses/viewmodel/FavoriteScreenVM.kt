package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.map
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCase
import ru.effective_mobile.courses.model.CourseMapper.mapToAppCourseList

internal class FavoriteScreenVM(
    private val getAllFavoriteCoursesUseCase: GetAllFavoriteCoursesUseCase
) : ViewModel() {

    fun getCourseListFlow() = getAllFavoriteCoursesUseCase().map {
        mapToAppCourseList(it)
    }

}