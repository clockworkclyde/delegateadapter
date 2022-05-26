package com.clockworkclyde.delegateadapterstud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clockworkclyde.delegateadapterstud.databinding.RefundItemBinding
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapter
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem
import com.clockworkclyde.delegateadapterstud.model.RefundInfoItem

class RefundInfoDelegateAdapter :
    DelegateAdapter<RefundInfoItem, RefundInfoDelegateAdapter.RefundInfoViewHolder>(
        RefundInfoItem::class.java
    ) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        RefundInfoViewHolder(
            RefundItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: RefundInfoItem,
        viewHolder: RefundInfoViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class RefundInfoViewHolder(private val binding: RefundItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RefundInfoItem) {
            binding.apply {
                ticketPriceLabel.text = item.ticketPrice.toString()
                insurancePriceLabel.text = item.baggagePrice.toString()
                totalSumLabel.text = item.totalPrice.toString()
            }
        }
    }

}