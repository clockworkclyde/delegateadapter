package com.clockworkclyde.delegateadapterstud.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clockworkclyde.delegateadapterstud.delegate.DelegateAdapterItem
import com.clockworkclyde.delegateadapterstud.model.FlightInfoItem
import com.clockworkclyde.delegateadapterstud.model.PassengerInfoItem
import com.clockworkclyde.delegateadapterstud.model.RefundInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _listItems = MutableLiveData<List<DelegateAdapterItem>>()
    val listItems: LiveData<List<DelegateAdapterItem>> get() = _listItems

    init {
        setupList()
    }

    private fun setupList() {
        val flightInfo = FlightInfoItem("100", "Surgut", "Moscow", "1:45", "4:20")
        val passengerInfo = PassengerInfoItem()
        val refundInfo = RefundInfoItem(11390, 2500)
        _listItems.value = listOf(
            passengerInfo,
            flightInfo,
            refundInfo,
            flightInfo,
            passengerInfo,
            refundInfo,
            refundInfo,
            refundInfo
        )
    }
}