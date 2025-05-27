package com.alqiran.portflio.ui.screens.home_screen.components

import androidx.compose.runtime.Composable
import com.alqiran.portflio.ui.components.TwoItemsPerRow
import com.alqiran.portflio.ui.screens.home_screen.model.Skill

@Composable
fun SkillsSection(skills: List<Skill>) {
    TwoItemsPerRow(skills.map { it.skillName })
}