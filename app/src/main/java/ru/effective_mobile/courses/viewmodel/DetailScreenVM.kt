package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCase
import ru.effective_mobile.courses.domain.usecase.course.ToggleFavoriteUseCase

internal class DetailScreenVM(
    private val savedStateHandle: SavedStateHandle,
    private val getCourseDetailUseCase: GetCourseDetailUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    fun getCourseFlow() =
        getCourseDetailUseCase(savedStateHandle.get<String>("courseId")!!)

    fun toggleFavorite(courseId: String) {
        viewModelScope.launch {
            println("VM: $courseId")
            toggleFavoriteUseCase(courseId = courseId)
        }
    }
}