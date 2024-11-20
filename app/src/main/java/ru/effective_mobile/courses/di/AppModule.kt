package ru.effective_mobile.courses.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.effective_mobile.courses.viewmodel.AccountScreenVM
import ru.effective_mobile.courses.viewmodel.DetailScreenVM
import ru.effective_mobile.courses.viewmodel.FavoriteScreenVM
import ru.effective_mobile.courses.viewmodel.MainScreenVM

val appModule = module {
    viewModelOf(::MainScreenVM)
    viewModelOf(::DetailScreenVM)
    viewModelOf(::FavoriteScreenVM)
    viewModelOf(::AccountScreenVM)
}