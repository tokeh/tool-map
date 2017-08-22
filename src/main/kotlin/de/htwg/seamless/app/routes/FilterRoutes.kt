package de.htwg.seamless.app.routes

import com.fasterxml.jackson.module.kotlin.readValue
import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.mapper
import de.htwg.seamless.app.util.FilterKeywords
import de.htwg.seamless.app.util.TemplateDataContainer
import spark.ModelAndView
import spark.Spark.*
import spark.template.handlebars.HandlebarsTemplateEngine

class FilterRoutes {

    init { initializeRoutes() }

    private fun initializeRoutes() {
        post("/filter") { req, _ ->
            val filterKeywords: FilterKeywords = mapper.readValue(req.body())

            val tools: MutableSet<Tool> = mutableSetOf()

            filterKeywords.toolNames.forEach {
                tools.addAll(Tool.where().toolName.icontains(it).findList())
            }

            filterKeywords.properties.forEach {
                tools.addAll(Tool.where().properties.name.icontains(it).findList())
            }

            filterKeywords.dimensions.forEach {
                tools.addAll(Tool.where().properties.dimensions.name.icontains(it).findList())
            }

            if (filterKeywords.toolNames.isEmpty()
                    && filterKeywords.dimensions.isEmpty()
                    && filterKeywords.properties.isEmpty()) {

                tools.addAll(Tool.all())
            }

            val dimensions = Dimension.where().index.asc().findList()
            val data = TemplateDataContainer(
                    tools = tools.toList().sortedBy(Tool::toolName).map { it.updateToolData() }
                    , dimensions = dimensions)

            HandlebarsTemplateEngine().render(
                    ModelAndView(data, "partials/map_tool_partial.hbs"))
        }
    }
}
