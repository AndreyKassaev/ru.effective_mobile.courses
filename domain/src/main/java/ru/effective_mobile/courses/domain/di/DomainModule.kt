package ru.effective_mobile.courses.domain.di

import org.koin.dsl.module
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListFlowUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListFlowUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCourseListUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetAllPersonalCoursesUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllPersonalCoursesUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.ToggleFavoriteUseCase
import ru.effective_mobile.courses.domain.usecase.course.ToggleFavoriteUseCaseImpl

val domainModule = module {
    factory<GetAllAvailableCourseListUseCase> {
        GetAllAvailableCourseListUseCaseImpl(get())
    }
    factory<GetAllFavoriteCoursesUseCase> {
        GetAllFavoriteCoursesUseCaseImpl(get())
    }
    factory<GetAllPersonalCoursesUseCase> {
        GetAllPersonalCoursesUseCaseImpl(get())
    }
    factory<GetCourseDetailUseCase> {
        GetCourseDetailUseCaseImpl(get())
    }
    factory<ToggleFavoriteUseCase> {
        ToggleFavoriteUseCaseImpl(get())
    }
    factory<GetAllAvailableCourseListFlowUseCase> {
        GetAllAvailableCourseListFlowUseCaseImpl(get())
    }
}