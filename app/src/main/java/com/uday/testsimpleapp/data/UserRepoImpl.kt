package com.uday.testsimpleapp.data

import com.uday.testsimpleapp.domain.UserRepoInterface
import javax.inject.Inject

class UserRepoImpl @Inject constructor(val dataSource: FakeDataSource) : UserRepoInterface {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }
}