package com.bagmanovam.nasa_planets.di

import com.bagmanovam.nasa_planets.presentation.home.HomeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeScreenViewModel)
}