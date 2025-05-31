package com.alqiran.portflio.data.datasourses.remote

import android.util.Log
import com.alqiran.portflio.data.datasourses.remote.model.Course
import com.alqiran.portflio.data.datasourses.remote.model.Project
import com.alqiran.portflio.data.datasourses.remote.model.User
import com.alqiran.portflio.utils.Constants.Companion.COLLECTION_NAME
import com.alqiran.portflio.utils.Constants.Companion.DOCUMENT_USER_NAME
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun getAllUserData(): User {
       return try {
           val cacheSnapshot = firestore.collection(COLLECTION_NAME)
               .document(DOCUMENT_USER_NAME)
               .get(Source.CACHE)
               .await()

           if (cacheSnapshot.exists()) {
               Log.d("Al-qiran", "Get not cached data")
               return cacheSnapshot.toObject(User::class.java)!!
           }

           val snapshot = firestore
               .collection(COLLECTION_NAME)
               .document(DOCUMENT_USER_NAME)
               .get()
               .await()

           if (snapshot.exists()) {
               snapshot.toObject(User::class.java)!!
           } else {
               throw NoSuchElementException("No user Data Exist")
           }

       } catch (e: Exception) {
           throw e
       }
    }

    suspend fun getAllProjects(): List<Project> {
        try {
            val userData = getAllUserData()

            val projects = userData.projects
            if (projects != null) {
                return projects
            } else {
                throw NoSuchElementException("There is no projects found")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getAllCourses(): List<Course> {
        try {
            val userData = getAllUserData()

            val courses = userData.courses
            if (courses != null) {
                return courses
            } else {
                throw NoSuchElementException("There is no Courses found")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getProjectItem(id: Int): Project {
        try {
            val userData = getAllUserData()

            val project = userData.projects?.find {it.id == id}
            if (project != null) {
                return project
            } else {
                throw NoSuchElementException("No Project with id $id")
            }
        } catch (e: Exception) {
            throw e
        }
    }

}
