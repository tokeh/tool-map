package de.htwg.seamless.app.util

import de.htwg.seamless.app.domain.*
import java.time.LocalDate
import java.util.*

class Util {
    companion object {

        fun createTestData() {
            val dimension = Dimension("Test Tool Dim 1", "Test Tool Dim 1 Descr")
            dimension.save()

            val property = Property("property1")
            property.dimensions.add(dimension)
            property.save()

            val tool = Tool(
                    toolName = "TestTool2",
                    description = "Test Tool 1 Descr",
                    properties = mutableSetOf(property))

            val link = Link("http1", "http1name")
            val rating = Rating(UUID.randomUUID(), "Rating 1 text", "ILIAS", "Tobias",
                    5, LocalDate.now())

            tool.links.addAll(mutableSetOf(link))
            tool.ratings.addAll(mutableSetOf(rating))

            tool.save()
        }
    }
}