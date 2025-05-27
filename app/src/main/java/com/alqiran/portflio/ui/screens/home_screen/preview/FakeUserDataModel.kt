package com.alqiran.portflio.ui.screens.home_screen.preview

import com.alqiran.portflio.ui.screens.home_screen.model.ContactAndAccounts
import com.alqiran.portflio.ui.screens.home_screen.model.Course
import com.alqiran.portflio.ui.screens.home_screen.model.Education
import com.alqiran.portflio.ui.screens.home_screen.model.Experience
import com.alqiran.portflio.ui.screens.home_screen.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.Skill
import com.alqiran.portflio.ui.screens.home_screen.model.Technology
import com.alqiran.portflio.ui.screens.home_screen.model.TechnologyTitle
import com.alqiran.portflio.ui.screens.home_screen.model.UserUiModel


val project = Project(
    id = 0,
    projectName = "TurboFit",
    description = "TurpoFit is a mobile fitness application built to support users in leading healthier lives by combining modern technology with essential wellness tools. Designed for Android and developed as part of the DEPI graduation project, TurpoFit focuses on creating a personalized and motivating experience for each user.\n" +
            "\n" +
            "The app begins by gathering key health details such as gender, height, weight, fitness level, and personal goals. This information allows TurpoFit to tailor its services and provide relevant insights that match the user’s lifestyle and objectives. Through seamless integration with Health Connect, the app keeps health data synchronized and up to date, giving users a comprehensive view of their physical progress.\n" +
            "\n" +
            "TurpoFit encourages physical activity by offering a selection of guided workouts suitable for various fitness levels. In addition to exercise, it promotes healthy eating habits by allowing users to explore nutritional information, track calorie intake, and even scan meals for automatic calorie estimates. Users can also create and follow healthy recipes, making meal preparation part of their wellness journey.\n" +
            "\n" +
            "To support hydration and overall well-being, TurpoFit includes daily water intake tracking and progress monitoring tools. Whether a user’s goal is weight loss, muscle gain, or general fitness, the app is designed to keep them engaged, informed, and on track—all within a simple and user-friendly interface.",
    url = "https://github.com/Abdallah-Alqiran/Fitness-App",
    image = "https://drive.google.com/uc?export=view&id=1LHqildeJORutspcTLq0RH39-s5mWJBns"
)

val projects: List<Project> = listOf(
    project,
    project.copy(id = 1),
    project.copy(id = 2, projectName = "Top app top app top app top app"),
    project.copy(id = 3, projectName = "hello world"),
    project.copy(id = 4, projectName = "Fake name and data"),
    project.copy(id = 5),
)

val contact = listOf(
    ContactAndAccounts(
        id = 0,
        webName = "linkedin",
        url = "https://www.linkedin.com/in/abdallah-alqiran/"
    ),
    ContactAndAccounts(
        id = 1,
        webName = "whatsapp",
        url = "https://wa.me/201016611062"
    ),
    ContactAndAccounts(
        id = 2,
        webName = "facebook",
        url = "https://www.linkedin.com/in/abdallah-alqiran/"
    ),

)

val skills: List<Skill> = listOf(
    Skill(
        id = 0,
        skillName = "Kotlin"
    ),
    Skill(
        id = 1,
        skillName = "compose"
    ),
    Skill(
        id = 2,
        skillName = "XML"
    ),
    Skill(
        id = 3,
        skillName = "Kotlin, compose, XML"
    ),
    Skill(
        id = 4,
        skillName = "Kotlin, compose"
    ),
    Skill(
        id = 5,
        skillName = "compose, XML"
    ),
    Skill(
        id = 6,
        skillName = "Kotlin, compose, XML"
    ),
    Skill(
        id = 7,
        skillName = "compose, XML"
    )
)


val technologyTitle: List<TechnologyTitle> = listOf(
    TechnologyTitle(
        id = 0,
        technologyTitle = "Programming Languages",
        technologies = listOf<Technology>(
            Technology(
                id = 0,
                technologyName = "kotlin kotlin kotlin kotlin"
            ),
            Technology(
                id = 1,
                technologyName = "web"
            ),
            Technology(
                id = 2,
                technologyName = "flutter"
            ),
            Technology(
                id = 3,
                technologyName = "c++"
            ),
            Technology(
                id = 4,
                technologyName = "kotlin kotlin kotlin kotlin"
            ),
        )
    ),
    TechnologyTitle(
        id = 1,
        technologyTitle = "Technologies",
        technologies = listOf<Technology>(
            Technology(
                id = 0,
                technologyName = "Compose"
            ),
            Technology(
                id = 1,
                technologyName = "JetpackCompose"
            ),
            Technology(
                id = 2,
                technologyName = "viewModel"
            ),
            Technology(
                id = 3,
                technologyName = "c++"
            ),
        )
    ),
)

val courses: List<Course> = listOf(
    Course(
        id = 0,
        courseName = "DEPI",
        courseDescription = "Mobile app development, Technical and non-technical sessions"
    ),
    Course(
        id = 1,
        courseName = "C++",
        courseDescription = "Mobile app development, Technical and non-technical sessions"
    ),
    Course(
        id = 2,
        courseName = "Innovation Bootcamp",
        courseDescription = "Learn how to start your business"
    ),
    Course(
        id = 3,
        courseName = "DEPI",
        courseDescription = "Mobile app development, Technical and non-technical sessions"
    ),
)

val experiences: List<Experience> = listOf(
    Experience(
        experienceTitle = "Working in graduation DEPI project",
        description = "My goal is to make a lot of things in the project and I think I did well in this project",
        date = "oct2024 to may2025"
    ),
    Experience(
        experienceTitle = "Working in graduation DEPI project",
        description = "My goal is to make a lot of things in the project and I think I did well in this project",
        date = "oct2024 to may2025"
    ),
    Experience(
        experienceTitle = "Working in graduation DEPI project",
        description = "My goal is to make a lot of things in the project and I think I did well in this project",
        date = "oct2024 to may2025"
    ),

    )


val fakeUserDataModel: UserUiModel = UserUiModel(
    userName = "Abdallah Alqiran",
    jobTitle = "Android Developer",
    userImage = "https://drive.google.com/uc?export=view&id=1n0QZ8XbQNSHjeMyogj0BdR_SqdQfPPdv",
    about = "I am a Computer Science student passionate about technology, innovation, and mobile app development. I am focused on enhancing my problem-solving skills and learning Android development using Kotlin.\n" +
            "\n" +
            "I work as a mentor at SVU University, where I guide students in building their problem-solving skills and sharing my knowledge.",
    cvUrl = "https://drive.google.com/drive/folders/1H3fWSC_sh6Sic_gVzc5DmiTSNDd0pXvx",
    projects = projects,
    contactAndAccounts = contact,
    skills = skills,
    technologiesAndTools = technologyTitle,
    courses = courses,
    experiences = experiences,
    education = Education(
        id = 0,
        date = "oct2023, current",
        university = "South Valley University",
        major = "CS and IT and Ai (all of above)",
    )
)




