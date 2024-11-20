package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.effective_mobile.courses.model.Course

internal class DetailScreenVM(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val courseMutable = MutableStateFlow<Course>(getCourse())
    private val course: StateFlow<Course> = courseMutable

    fun getCourseFlow() = course

    private fun getCourse(): Course {
        //useCase(savedStateHandle.get<String>("courseId")) -> repo
        return Course.mock
    }
}