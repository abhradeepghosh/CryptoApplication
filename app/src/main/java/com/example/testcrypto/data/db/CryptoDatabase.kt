package com.example.testcrypto.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testcrypto.data.db.dao.CryptoDao
import com.example.testcrypto.data.db.entity.CoinMarketEntity

@Database(
    entities = [CoinMarketEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun cryptoDao(): CryptoDao
}