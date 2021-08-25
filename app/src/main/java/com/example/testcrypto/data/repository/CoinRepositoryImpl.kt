package com.example.testcrypto.data.repository

import com.example.testcrypto.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.testcrypto.data.db.dao.CryptoDao
import com.example.testcrypto.data.db.entity.CoinMarketEntity
import com.example.testcrypto.data.model.CoinDetailItem
import com.example.testcrypto.data.model.CoinMarketItem
import com.example.testcrypto.data.network.CryptoService
import com.example.testcrypto.util.Resource
import com.example.testcrypto.util.getResourceByDatabaseRequest
import com.example.testcrypto.util.getResourceByNetworkRequest

class CoinRepositoryImpl @Inject constructor(
    private val cryptoService: CryptoService,
    private val cryptoDao: CryptoDao
) : CoinRepository {

    override suspend fun getAllCoins(): Flow<Resource<List<CoinMarketItem>>> = flow {
        emit(getResourceByNetworkRequest { cryptoService.getAllCoins() })
    }

    override suspend fun getCoinByID(id: String): Flow<Resource<CoinDetailItem>> = flow {
        emit(getResourceByNetworkRequest { cryptoService.getCoinByID(id) })
    }

    override suspend fun insertAllCoins(listCrypto: List<CoinMarketEntity>): Flow<Resource<Unit>> =
        flow {
            emit(getResourceByDatabaseRequest { cryptoDao.insertAllCrypto(listCrypto) })
        }

    override suspend fun getCoinsByParameter(parameter: String): Flow<Resource<List<CoinMarketEntity>>> =
        flow {
            emit(getResourceByDatabaseRequest { cryptoDao.getCryptoByParameter(parameter) })
        }
}