package com.clockworkclyde.delegateadapterstud.model

import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem

data class FlightInfoItem(
    val bookingId: String,
    val cityFrom: String,
    val cityTo: String,
    val departureTime: String,
    val arrivalTime: String
) : DelegateAdapterItem {

    override fun id(): Any = bookingId

    override fun content(): Any = FlightInfoContent(departureTime, arrivalTime)

    override fun payload(other: Any): DelegateAdapterItem.Payloadable {
        if (other is FlightInfoItem) {
            if (departureTime != other.departureTime) {
                return ChangePayload.DepartureTimeChanged(other.departureTime)
            }
            if (arrivalTime != other.arrivalTime) {
                return ChangePayload.ArrivalTimeChanged(other.arrivalTime)
            }
        }
        return DelegateAdapterItem.Payloadable.None
    }

    inner class FlightInfoContent(val departureTime: String, val arrivalTime: String) {

        override fun equals(other: Any?): Boolean {
            if (other is FlightInfoContent) {
                return departureTime == other.departureTime && arrivalTime == other.arrivalTime
            }
            return false
        }

        override fun hashCode(): Int {
            var result = departureTime.hashCode()
            result = 31 * result + arrivalTime.hashCode()
            return result
        }
    }


    sealed class ChangePayload : DelegateAdapterItem.Payloadable {
        data class DepartureTimeChanged(val departureTime: String) : ChangePayload()
        data class ArrivalTimeChanged(val arrivalTime: String) : ChangePayload()
    }
}
