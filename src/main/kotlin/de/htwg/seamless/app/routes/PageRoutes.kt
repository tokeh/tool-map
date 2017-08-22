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
        get("/") { _, _ ->

            var favourites = Tool.query().select("rating").orderBy("rating").findList()

            favourites = when (favourites.size < 3) {
                true -> favourites.subList(0, favourites.size)
                false -> favourites.subList(0, 3)
            }

            val data = TemplateDataContainer(hashMapOf(Pair("home", true)),
                    Tool.all().map { it.updateToolData() }, Dimension.all(), Property.all(), favourites)

            HandlebarsTemplateEngine().render(
                    ModelAndView(data, "map_template.hbs")
            )
        }

        get("/info") { _, _ ->
            HandlebarsTemplateEngine().render(
                    ModelAndView(TemplateDataContainer(hashMapOf(Pair("info", true))), "info_template.hbs")
            )
        }
    }

}
