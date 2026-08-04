package com.uday.testsimpleapp.data

import com.uday.testsimpleapp.domain.UserRepoInterface

class UserRepoImpl(val dataSource: FakeDataSource) : UserRepoInterface {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }
}