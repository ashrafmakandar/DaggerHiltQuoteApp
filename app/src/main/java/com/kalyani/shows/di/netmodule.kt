package com.kalyani.shows.di

import com.kalyani.quotesapp.network.QuoteApi
import com.kalyani.shows.network.tvApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class netmodule {


    @Provides
    @Singleton
    @JvmSuppressWildcards
    @Named("ret1")
    fun provideRetrofit(

    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create())


            .build()

    @Provides
    @Singleton
    @JvmSuppressWildcards
    fun provideApiService(@Named("ret1") retrofit: Retrofit): tvApi =
        retrofit.create(tvApi::class.java)


}