package com.bagmanovam.nasa_planets.di

import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bagmanovam.nasa_planets.BuildConfig
import com.bagmanovam.nasa_planets.data.db.SpaceNasaDatabase
import com.bagmanovam.nasa_planets.data.internet.NasaApi
import com.bagmanovam.nasa_planets.data.repository.SearchSpaceItemsRepositoryImpl
import com.bagmanovam.nasa_planets.data.repository.SpaceItemsDbRepositoryImpl
import com.bagmanovam.nasa_planets.domain.interactor.GetSpaceItemDbInteractor
import com.bagmanovam.nasa_planets.domain.interactor.GetSpaceItemsDbInteractor
import com.bagmanovam.nasa_planets.domain.interactor.GetSpaceItemsInteractor
import com.bagmanovam.nasa_planets.domain.interactor.SaveSpaceItemsDbInteractor
import com.bagmanovam.nasa_planets.domain.repository.SearchSpaceItemsRepository
import com.bagmanovam.nasa_planets.domain.repository.SpaceItemsDbRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemDbUseCase
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsDbUseCase
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsUseCase
import com.bagmanovam.nasa_planets.domain.useCase.SaveSpaceItemsDbUseCase
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
    single<SpaceItemsDbRepository> { SpaceItemsDbRepositoryImpl(get()) }

    factory<GetSpaceItemsUseCase> { GetSpaceItemsInteractor(get()) }
    factory<GetSpaceItemsDbUseCase> { GetSpaceItemsDbInteractor(get()) }
    factory<SaveSpaceItemsDbUseCase> { SaveSpaceItemsDbInteractor(get()) }
    factory<GetSpaceItemDbUseCase> { GetSpaceItemDbInteractor(get()) }


    single<SpaceNasaDatabase> {
        Room.databaseBuilder(get(), SpaceNasaDatabase::class.java, "space_db")
            .fallbackToDestructiveMigration(true)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.i("Room", "onCreate: ")
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    Log.i("Room", "onOpen: ${db.path}")
                }

                override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                    super.onDestructiveMigration(db)
                    Log.i("Room", "onDestructiveMigration: ${db.version}")
                }
            })
            .build()
    }

    single {
        get<SpaceNasaDatabase>().getDao()
    }
}