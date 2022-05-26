package com.clockworkclyde.delegateadapterstud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clockworkclyde.delegateadapterstud.databinding.ItemPassengerBinding
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapter
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem
import com.clockworkclyde.delegateadapterstud.model.PassengerInfoItem

class PassengerInfoDelegateAdapter(private val onAuthClicked: (String) -> Unit) :
    DelegateAdapter<PassengerInfoItem, PassengerInfoDelegateAdapter.PassengerInfoViewHolder>(PassengerInfoItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        PassengerInfoViewHolder(
            ItemPassengerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: PassengerInfoItem,
        viewHolder: PassengerInfoViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class PassengerInfoViewHolder(private val binding: ItemPassengerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PassengerInfoItem) {
            binding.apply {
                phoneEditText.setText(item.phone)
                otpButton.setOnClickListener {
                    onAuthClicked(binding.phoneEditText.text.toString())
                }
            }
        }
    }
}