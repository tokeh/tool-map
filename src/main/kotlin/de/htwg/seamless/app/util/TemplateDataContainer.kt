package de.htwg.seamless.app.util

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.domain.Tool

data class TemplateDataContainer(
        val nav: Map<String, Boolean> = hashMapOf(),

        val tools: List<Tool> = listOf(),

        val dimensions: List<Dimension> = listOf(),

        val properties: List<Property> = listOf(),

        val favourites: List<Tool> = listOf()
)
