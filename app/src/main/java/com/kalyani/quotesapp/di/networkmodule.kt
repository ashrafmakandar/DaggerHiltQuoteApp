package com.kalyani.quotesapp.di

import com.kalyani.quotesapp.network.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class networkmodule {


    @Provides
    @Singleton
    @JvmSuppressWildcards
    fun provideRetrofit(

    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://programming-quotes-api.herokuapp.com/quotes/")
            .addConverterFactory(GsonConverterFactory.create())


            .build()

    @Provides
    @Singleton
    @JvmSuppressWildcards
    fun provideApiService(retrofit: Retrofit): QuoteApi =
        retrofit.create(QuoteApi::class.java)


}