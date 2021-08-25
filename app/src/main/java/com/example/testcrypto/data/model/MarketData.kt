package com.example.testcrypto.data.model

import com.example.testcrypto.data.model.CurrentPrice
import com.example.testcrypto.data.model.High24h
import com.example.testcrypto.data.model.Low24h
import com.google.gson.annotations.SerializedName
data class MarketData(
    @SerializedName("current_price")
    val currentPrice: CurrentPrice,

    @SerializedName("last_updated")
    val lastUpdated: String,

    @SerializedName("price_change_24h")
    val priceChange24h: Double,

    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,

    @SerializedName("high_24h")
    val highestPrice24h: High24h,

    @SerializedName("low_24h")
    val lowestPrice24h: Low24h,

    )