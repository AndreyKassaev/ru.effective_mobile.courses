package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.ViewModel
import ru.effective_mobile.courses.domain.usecase.course.GetAllPersonalCoursesUseCase

internal class AccountScreenVM(
    private val getAllPersonalCoursesUseCase: GetAllPersonalCoursesUseCase
) : ViewModel() {

    fun getCourseListFlow() = getAllPersonalCoursesUseCase()
}