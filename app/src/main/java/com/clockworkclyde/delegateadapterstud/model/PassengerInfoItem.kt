package com.clockworkclyde.delegateadapterstud.model

import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem

data class PassengerInfoItem(
    val phone: String = "+7"
): DelegateAdapterItem {

    override fun id(): Any = PassengerInfoItem::class.toString()

    override fun content(): Any = phone
}