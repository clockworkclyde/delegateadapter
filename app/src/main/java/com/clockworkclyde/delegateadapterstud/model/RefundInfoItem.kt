package com.clockworkclyde.delegateadapterstud.model

import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem

data class RefundInfoItem(
    val ticketPrice: Int,
    val baggagePrice: Int
): DelegateAdapterItem {

    val totalPrice = ticketPrice + baggagePrice

    override fun id(): Any = RefundInfoItem::class.toString()

    override fun content(): Any = totalPrice
}