package com.example.testcrypto.data.repository

import com.example.testcrypto.data.db.entity.CoinMarketEntity
import com.example.testcrypto.data.model.CoinDetailItem
import com.example.testcrypto.data.model.CoinMarketItem
import com.example.testcrypto.util.Resource
import kotlinx.coroutines.flow.Flow
import java.util.*

interface CoinRepository {
    suspend fun getAllCoins(): Flow<Resource<List<CoinMarketItem>>>
    suspend fun getCoinByID(id: String): Flow<Resource<CoinDetailItem>>
    suspend fun insertAllCoins(listCrypto: List<CoinMarketEntity>): Flow<Resource<Unit>>
    suspend fun getCoinsByParameter(parameter: String): Flow<Resource<List<CoinMarketEntity>>>
}