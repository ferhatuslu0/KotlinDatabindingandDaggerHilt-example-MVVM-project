package com.example.kisilerapp.di

import com.example.kisilerapp.data.datasource.KisilerDataSource
import com.example.kisilerapp.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerRepository(kds :KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource() : KisilerDataSource{
        return KisilerDataSource()
    }
}