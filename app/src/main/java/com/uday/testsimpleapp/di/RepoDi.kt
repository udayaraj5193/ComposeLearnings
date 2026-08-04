package com.uday.testsimpleapp.di

import com.uday.testsimpleapp.data.UserRepoImpl
import com.uday.testsimpleapp.domain.UserRepoInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoDi {
    @Binds
    @Singleton
    abstract fun bindUserRepo(userRepoImpl: UserRepoImpl): UserRepoInterface
}