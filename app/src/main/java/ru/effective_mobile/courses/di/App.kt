package ru.effective_mobile.courses.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.effective_mobile.courses.data.di.dataModule
import ru.effective_mobile.courses.domain.di.domainModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }
}