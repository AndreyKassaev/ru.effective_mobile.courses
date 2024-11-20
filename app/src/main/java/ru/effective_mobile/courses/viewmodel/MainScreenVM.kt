package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.ViewModel
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCoursesUseCase

internal class MainScreenVM(
    private val getAllAvailableCoursesUseCase: GetAllAvailableCoursesUseCase
) : ViewModel() {

    fun getCourseListFlow() = getAllAvailableCoursesUseCase()

}