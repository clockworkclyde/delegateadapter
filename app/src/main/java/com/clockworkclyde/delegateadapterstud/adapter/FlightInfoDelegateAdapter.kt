package com.clockworkclyde.delegateadapterstud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clockworkclyde.delegateadapterstud.databinding.ItemBookingBinding
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapter
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem
import com.clockworkclyde.delegateadapterstud.model.FlightInfoItem

class FlightInfoDelegateAdapter :
    DelegateAdapter<FlightInfoItem, FlightInfoDelegateAdapter.FlightInfoViewHolder>(FlightInfoItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        FlightInfoViewHolder(
            ItemBookingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: FlightInfoItem,
        viewHolder: FlightInfoViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class FlightInfoViewHolder(private val binding: ItemBookingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FlightInfoItem) {
            binding.apply {
                routeLabel.text = "${item.departureTime} - ${item.arrivalTime}"
                routeLabel2.text = "${item.arrivalTime} - ${item.departureTime}"
            }
        }


    }
}