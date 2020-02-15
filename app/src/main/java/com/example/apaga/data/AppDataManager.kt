package com.example.apaga.data

import androidx.lifecycle.LiveData
import com.example.apaga.data.db.model.User

class AppDataManager : DataManager {
    override fun getCurrentUserLoggedInMode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserId(): Long? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserId(userId: Long?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserName(userName: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserEmail(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserEmail(email: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserProfilePicUrl(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserProfilePicUrl(profilePicUrl: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAccessToken(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAccessToken(accessToken: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(): LiveData<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}