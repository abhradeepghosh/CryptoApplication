package com.example.testcrypto.ui.coin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testcrypto.R
import com.example.testcrypto.data.db.entity.CoinMarketEntity
import com.example.testcrypto.data.model.CoinMarketItem
import com.example.testcrypto.data.repository.CoinRepository
import com.example.testcrypto.ui.BaseViewModel
import com.example.testcrypto.util.Resource
import com.example.testcrypto.util.Result
import com.example.testcrypto.util.enums.Status
import com.example.testcrypto.util.getCoinMarketEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val coinRepository: CoinRepository) :
    BaseViewModel() {

    private val _allCoins = MutableLiveData<Resource<List<CoinMarketItem>>>()
    val allCoins: LiveData<Resource<List<CoinMarketItem>>> = _allCoins

    private val _coinByParameter = MutableLiveData<Resource<List<CoinMarketEntity>>>()
    val coinByParameter: LiveData<Resource<List<CoinMarketEntity>>> = _coinByParameter

    fun getCoinsByParameter(parameter: String) = viewModelScope.launch {
        coinRepository.getCoinsByParameter(parameter.format())
            .onStart {
                _result.value = Result(loading = R.string.loading)
            }
            .catch {
                Log.v("errorGetCoinByParameter", it.message.toString())
            }
            .collect {
                _coinByParameter.value = it
            }
    }

    fun getAllCoins() = viewModelScope.launch {
        coinRepository.getAllCoins()
            .onStart {
                _result.value = Result(loading = R.string.loading)
            }
            .catch {
                Log.v("errorGetAllCoins", it.message.toString())
            }
            .collect {
                _allCoins.value = it
            }
    }

    fun insertAllCoins(listCrypto: List<CoinMarketItem>) = viewModelScope.launch {
        val coinEntityList = getCoinMarketEntity(listCrypto)

        coinRepository.insertAllCoins(coinEntityList)
            .onStart {
                _result.value = Result(loading = R.string.coin_loading)
            }
            .collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let {
                            Result(success = R.string.coin_success)
                        }
                    }
                    Status.ERROR -> Result(success = R.string.coin_error)
                }
            }
    }

}