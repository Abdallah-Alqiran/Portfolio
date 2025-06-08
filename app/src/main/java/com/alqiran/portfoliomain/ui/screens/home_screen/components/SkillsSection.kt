package com.alqiran.portfoliomain.ui.screens.home_screen.components

import androidx.compose.runtime.Composable
import com.alqiran.portfoliomain.ui.components.TwoItemsPerRow
import com.alqiran.portfoliomain.ui.model.SkillUiModel

@Composable
fun SkillsSection(skills: List<SkillUiModel>) {
    TwoItemsPerRow(skills.map { it.skillName })
}