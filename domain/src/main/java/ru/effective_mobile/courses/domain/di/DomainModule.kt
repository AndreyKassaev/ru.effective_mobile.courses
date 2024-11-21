package ru.effective_mobile.courses.domain.di

import org.koin.dsl.module
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCoursesUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllAvailableCoursesUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllFavoriteCoursesUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetAllPersonalCoursesUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetAllPersonalCoursesUseCaseImpl
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCase
import ru.effective_mobile.courses.domain.usecase.course.GetCourseDetailUseCaseImpl

val domainModule = module {
    factory<GetAllAvailableCoursesUseCase> {
        GetAllAvailableCoursesUseCaseImpl(get())
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
}