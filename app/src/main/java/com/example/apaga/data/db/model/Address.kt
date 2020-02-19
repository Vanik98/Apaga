package com.example.apaga.data.db.model

data class Address(
        val streetName : String,
        val building : String,
        val apt : String,
        val floor : Int,
        val entrance : String,
        val region: Region
) {

}