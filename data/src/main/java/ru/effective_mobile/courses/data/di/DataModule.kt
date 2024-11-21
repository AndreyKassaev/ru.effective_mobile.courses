package ru.effective_mobile.courses.data.di

import org.koin.dsl.module
import ru.effective_mobile.courses.data.repository.CourseRepositoryImpl
import ru.effective_mobile.courses.domain.repository.CourseRepository

val dataModule = module {
    single<CourseRepository> {
        CourseRepositoryImpl()
    }
}