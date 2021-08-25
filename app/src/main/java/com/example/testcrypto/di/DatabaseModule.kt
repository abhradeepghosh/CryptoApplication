package com.example.testcrypto.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.testcrypto.data.db.CryptoDatabase
import com.example.testcrypto.data.db.dao.CryptoDao
import com.example.testcrypto.util.Constants

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CryptoDatabase =
        Room.databaseBuilder(context, CryptoDatabase::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCryptoDao(database: CryptoDatabase): CryptoDao = database.cryptoDao()

}