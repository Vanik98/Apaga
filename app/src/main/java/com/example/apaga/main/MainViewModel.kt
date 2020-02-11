package com.example.apaga.main

import com.example.apaga.data.DataManager
import com.example.apaga.utils.rx.SchedulerProvider

class MainViewModel (
        val dataManager: DataManager,
        val schedulerProvider: SchedulerProvider
){

}