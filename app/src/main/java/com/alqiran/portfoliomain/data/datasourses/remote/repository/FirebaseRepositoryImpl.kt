package com.alqiran.portfoliomain.data.datasourses.remote.repository

import com.alqiran.portfoliomain.data.datasourses.remote.RemoteDataSource
import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactMessage
import com.alqiran.portfoliomain.data.datasourses.remote.model.User
import com.alqiran.portfoliomain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): FirebaseRepository{

    override suspend fun getAllUserData(): User {
        return remoteDataSource.getAllUserData()
    }

    override fun sendMessage(contactMessage: ContactMessage) {
        return remoteDataSource.sendMessage(contactMessage)
    }
}