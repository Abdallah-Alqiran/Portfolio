package com.alqiran.portflio.ui.screens.home_screen.model

data class UserUiModel(
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










