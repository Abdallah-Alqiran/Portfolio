package com.alqiran.portflio.ui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.alqiran.portflio.ui.model.ProjectUiModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data object SplashScreenRoute

@Serializable
data object HomeScreenRoute

@Serializable
data class ProjectItemRoute(val project: ProjectUiModel)

@Serializable
data object ProjectsScreenRoute

@Serializable
data object CoursesScreenRoute

@Serializable
data object MessageScreenRoute

object CustomNavType {
    val projectItemType = object : NavType<ProjectUiModel>(
        isNullableAllowed = false
    ) {
        override fun get(
            bundle: Bundle,
            key: String
        ): ProjectUiModel? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): ProjectUiModel {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: ProjectUiModel): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(
            bundle: Bundle,
            key: String,
            value: ProjectUiModel
        ) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}