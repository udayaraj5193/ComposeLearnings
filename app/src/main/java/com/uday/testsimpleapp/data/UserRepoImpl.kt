package com.uday.testsimpleapp.data

import com.uday.testsimpleapp.data.retrofit.ApiService
import com.uday.testsimpleapp.domain.UserRepoInterface
import javax.inject.Inject

class UserRepoImpl @Inject constructor(private val apiService: ApiService) : UserRepoInterface {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}
