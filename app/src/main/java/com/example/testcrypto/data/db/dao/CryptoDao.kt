package com.example.testcrypto.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testcrypto.data.db.entity.CoinMarketEntity
import java.util.*

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCrypto(listCrypto: List<CoinMarketEntity>)

    @Query("SELECT * FROM tbl_coin_list WHERE name LIKE :searchParameter OR symbol LIKE :searchParameter")
    suspend fun getCryptoByParameter(searchParameter: String): List<CoinMarketEntity>
}