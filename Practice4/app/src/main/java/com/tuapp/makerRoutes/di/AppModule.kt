package com.tuapp.MakerRouter.di

import com.tuapp.MakerRouter.data.remote.RoutesApi
import com.tuapp.MakerRouter.data.remote.repository.RoutesRepositoryImpl
import com.tuapp.MakerRouter.domain.repository.RoutesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://apipractico4.jmacboy.com/api/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideRoutesApi(retrofit: Retrofit): RoutesApi {
        return retrofit.create(RoutesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoutesRepository(api: RoutesApi): RoutesRepository {
        return RoutesRepositoryImpl(api)
    }

}