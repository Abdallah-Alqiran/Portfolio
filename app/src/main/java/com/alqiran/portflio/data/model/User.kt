package com.alqiran.portflio.data.model

import com.alqiran.portflio.ui.screens.home_screen.model.ContactAndAccounts
import com.alqiran.portflio.ui.screens.home_screen.model.Course
import com.alqiran.portflio.ui.screens.home_screen.model.Education
import com.alqiran.portflio.ui.screens.home_screen.model.Experience
import com.alqiran.portflio.ui.screens.home_screen.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.Skill
import com.alqiran.portflio.ui.screens.home_screen.model.Technology
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
    val education: Education?
)


//data class ContactAndAccounts (
//    val id: Int,
//    val webName: String,
//    val url: String
//)
//
//data class Course (
//    val id: Int,
//    val courseName: String,
//    val courseDescription: String,
//)
//
//
//data class Education(
//    val id : Int,
//    val university: String,
//    val date: String,
//    val major: String
//)
//
//data class Experience(
//    val experienceTitle: String,
//    val date: String,
//    val description: String,
//)
//
//data class Project(
//    val id: Int,
//    val image: String,
//    val projectName: String,
//    val description: String,
//    val url: String
//)
//
//data class Skill(
//    val id: Int,
//    val skillName: String
//)
//
//data class Technology (
//    val id: Int,
//    val technologyName: String
//)
//
//data class TechnologyTitle (
//    val id: Int,
//    val technologyTitle: String,
//    val technologies: List<Technology>
//)