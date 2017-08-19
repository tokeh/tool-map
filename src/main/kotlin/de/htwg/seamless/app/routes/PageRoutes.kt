package de.htwg.seamless.app.routes

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.util.TemplateDataContainer
import spark.ModelAndView
import spark.Spark.*
import spark.template.handlebars.HandlebarsTemplateEngine

class PageRoutes {

    init { initializeRoutes() }

    private fun initializeRoutes() {
        get("/toolMap") { _, _ ->
            val data = TemplateDataContainer(Tool.all(), Dimension.all(), Property.all(), Tool.all())

            HandlebarsTemplateEngine().render(
                    ModelAndView(data, "map_template.hbs")
            )
        }
    }

}