package de.htwg.seamless.app.util

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.Tool

data class TemplateDataContainer(
        val tools: List<Tool>,

        val dimensions: List<Dimension>,

        val favourites: List<Tool>
)
