package com.bagmanovam.nasa_planets.di

import com.bagmanovam.nasa_planets.BuildConfig
import com.bagmanovam.nasa_planets.data.internet.NasaApi
import com.bagmanovam.nasa_planets.data.repository.SearchSpaceItemsRepositoryImpl
import com.bagmanovam.nasa_planets.domain.interactor.GetSpaceItemsInteractor
import com.bagmanovam.nasa_planets.domain.repository.SearchSpaceItemsRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nasa.gov/planetary/")
            .build()
            .create(NasaApi::class.java)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newUrl = chain.request().url.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()

                val newRequest = chain.request().newBuilder().url(newUrl).build()
                chain.proceed(newRequest)
            }
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    if (BuildConfig.DEBUG)
                        HttpLoggingInterceptor.Level.BODY
                    else
                        HttpLoggingInterceptor.Level.BASIC
                )
            )
            .build()
    }

    single<SearchSpaceItemsRepository> { SearchSpaceItemsRepositoryImpl(get()) }


    factory<GetSpaceItemsUseCase> { GetSpaceItemsInteractor(get()) }
}