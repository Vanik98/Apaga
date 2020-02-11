package com.example.apaga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apaga.data.DataManager
import com.example.apaga.main.MainViewModel
import com.example.apaga.utils.rx.SchedulerProvider
import javax.inject.Inject

class ViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {
    private lateinit var dataManager: DataManager
    private lateinit var schedulerProvider: SchedulerProvider

    @Inject
    fun ViewModelProviderFactory(dataManager: DataManager, schedulerProvider: SchedulerProvider) {
        this.dataManager = dataManager
        this.schedulerProvider = schedulerProvider
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            return MainViewModel(dataManager, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}