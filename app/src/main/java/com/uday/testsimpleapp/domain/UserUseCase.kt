package com.uday.testsimpleapp.domain

import com.uday.testsimpleapp.data.User
import javax.inject.Inject

class UserUseCase @Inject constructor(val userImpl: UserRepoInterface) {
    suspend operator fun invoke(): List<User> {
        return userImpl.getUsers()
    }
}
