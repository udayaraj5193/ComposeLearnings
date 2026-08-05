package com.uday.testsimpleapp.data

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val name: String,
    val phone: String,
    val email: String,
    @SerializedName("photo") val imgUrl: String? = null
)
