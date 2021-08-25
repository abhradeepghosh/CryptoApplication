package com.example.testcrypto.ui.coin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testcrypto.data.model.CoinMarketItem
import com.example.testcrypto.databinding.RvItemCoinBinding


class CoinAdapter : ListAdapter<CoinMarketItem, CoinViewHolder>(CoinCallback()) {

//    private lateinit var coinOnClick: (CoinMarketItem) -> Unit
//
//    fun setCoinOnClickListener(coinOnClick: (CoinMarketItem) -> Unit) {
//        this.coinOnClick = coinOnClick
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder =
        CoinViewHolder(
            RvItemCoinBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) =
        holder.bind(getItem(position))

}

class CoinViewHolder(
    private val binding: RvItemCoinBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(coinMarketItem: CoinMarketItem) {
        binding.coin = coinMarketItem

//        itemView.setOnClickListener {
//            coinOnClick(coinMarketItem)
//        }
    }
}

class CoinCallback : DiffUtil.ItemCallback<CoinMarketItem>() {
    override fun areItemsTheSame(
        oldItem: CoinMarketItem,
        newItem: CoinMarketItem
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: CoinMarketItem,
        newItem: CoinMarketItem
    ): Boolean = oldItem == newItem

}