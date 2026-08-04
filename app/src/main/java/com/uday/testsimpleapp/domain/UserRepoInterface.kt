package com.uday.testsimpleapp.domain

import com.uday.testsimpleapp.data.User

interface UserRepoInterface {

    suspend fun getUsers(): List<User>
}