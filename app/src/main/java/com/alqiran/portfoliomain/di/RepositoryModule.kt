package com.alqiran.portfoliomain.di

import com.alqiran.portfoliomain.data.datasourses.remote.repository.FirebaseRepositoryImpl
import com.alqiran.portfoliomain.repository.FirebaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(impl: FirebaseRepositoryImpl): FirebaseRepository
}