package com.example.apaga.data.prefs

import com.example.apaga.data.DataManager

interface PreferencesHelper {

    fun getCurrentUserLoggedInMode(): Int

//    fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode?)

    fun getCurrentUserId(): Long?

    fun setCurrentUserId(userId: Long?)

    fun getCurrentUserName(): String?

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getCurrentUserProfilePicUrl(): String?

    fun setCurrentUserProfilePicUrl(profilePicUrl: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)
}