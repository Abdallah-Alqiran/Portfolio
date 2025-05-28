package com.alqiran.portflio.data.model

import com.alqiran.portflio.ui.screens.home_screen.model.ContactAndAccounts
import com.alqiran.portflio.ui.screens.home_screen.model.Course
import com.alqiran.portflio.ui.screens.home_screen.model.Education
import com.alqiran.portflio.ui.screens.home_screen.model.Experience
import com.alqiran.portflio.ui.screens.home_screen.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.Skill
import com.alqiran.portflio.ui.screens.home_screen.model.TechnologyTitle

data class User(
    val userName: String,
    val jobTitle: String,
    val userImage: String?,
    val about: String?,
    val cvUrl: String?,
    val projects: List<Project>?,
    val contactAndAccounts: List<ContactAndAccounts>?,
    val skills: List<Skill>?,
    val technologiesAndTools: List<TechnologyTitle>?,
    val courses: List<Course>?,
    val experiences: List<Experience>?,
    val education: List<Education>?
)
