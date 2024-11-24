package ru.effective_mobile.courses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListFlowUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListUseCase
import ru.effective_mobile.courses.model.CourseMapper.mapToAppCourseList

internal class MainScreenVM(
    private val getAllAvailableCourseListUseCase: GetAllAvailableCourseListUseCase,
    private val getAllAvailableCourseListFlowUseCase: GetAllAvailableCourseListFlowUseCase
) : ViewModel() {

    fun getAllAvailableCourseListFlow() = getAllAvailableCourseListFlowUseCase().map {
        mapToAppCourseList(it)
    }

    fun getMoreCourseList() {
        viewModelScope.launch {
            getAllAvailableCourseListUseCase()
        }
    }

}