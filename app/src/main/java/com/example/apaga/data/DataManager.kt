package com.example.apaga.data

import com.example.apaga.data.db.DbHelper
import com.example.apaga.data.network.ApiHelper
import com.example.apaga.data.prefs.PreferencesHelper

interface  DataManager : DbHelper, PreferencesHelper, ApiHelper {

}