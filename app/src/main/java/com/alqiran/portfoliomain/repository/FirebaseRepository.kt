package com.alqiran.portfoliomain.repository

import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactMessage
import com.alqiran.portfoliomain.data.datasourses.remote.model.User

interface FirebaseRepository {

    suspend fun getAllUserData(): User

    fun sendMessage(contactMessage: ContactMessage)
}