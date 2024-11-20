package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCase

internal class DetailScreenVM(
    private val savedStateHandle: SavedStateHandle,
    private val getCourseDetailUseCase: GetCourseDetailUseCase
) : ViewModel() {

    fun getCourseFlow() = getCourseDetailUseCase(
        courseId = savedStateHandle.get<String>("courseId")
    )

}