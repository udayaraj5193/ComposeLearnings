package com.uday.testsimpleapp.data.retrofit

import com.uday.testsimpleapp.data.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}