package com.example.apaga.data.network.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

@SuppressLint("ParcelCreator")
 class Notification(val massage:String) : Parcelable{
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

