package ru.effective_mobile.courses.data.di

import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.effective_mobile.courses.data.api.ApiService
import ru.effective_mobile.courses.data.db.AppDatabase
import ru.effective_mobile.courses.data.db.CourseDao
import ru.effective_mobile.courses.data.repository.CourseRepositoryImpl
import ru.effective_mobile.courses.data.util.PreferenceManager
import ru.effective_mobile.courses.domain.repository.CourseRepository

val dataModule = module {

    single<CourseRepository> {
        CourseRepositoryImpl(get(), get(), get())
    }

    singleOf(::ApiService)

    single {
        Room.databaseBuilder(
            androidApplication() as Context,
            AppDatabase::class.java,
            "app.db"
        ).build()
    }

    single<CourseDao> {
        val database = get<AppDatabase>()
        database.courseDao()
    }

    singleOf(::PreferenceManager)
}