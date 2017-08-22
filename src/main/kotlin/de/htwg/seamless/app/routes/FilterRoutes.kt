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
                Tool.where().toolName.contains(it).findList()
            }

            filterKeywords.properties.forEach {
                Tool.where().properties.name.contains(it).findList()
            }

            filterKeywords.dimensions.forEach {
                Tool.where().properties.dimensions.name.contains(it).findList()
            }

            val dimensions = Dimension.where().index.asc().findList()
            val data = TemplateDataContainer(tools = tools.toList().map { it.updateToolData() }, dimensions = dimensions)

            println(HandlebarsTemplateEngine().render(
                    ModelAndView(data, "map_template.hbs")))
        }
    }
}
