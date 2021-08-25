package com.example.testcrypto.di

import com.example.testcrypto.data.repository.CoinRepository
import com.example.testcrypto.data.repository.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideCoinRepository(repository: CoinRepositoryImpl): CoinRepository
}