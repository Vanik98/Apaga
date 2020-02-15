package com.example.apaga.data.network.model

data class User(
        var id: String,
        val fullName: String,
        val phone: String,
        val email: String,
        val password : String
) {
    constructor() : this("", "", "", "","")

}