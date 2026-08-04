package com.uday.testsimpleapp.domain

import com.uday.testsimpleapp.data.User
import com.uday.testsimpleapp.data.UserRepoImpl

class UserUseCase(val userImpl: UserRepoImpl) {
    suspend operator fun invoke(): List<User> {
        return userImpl.getUsers()
    }
}
