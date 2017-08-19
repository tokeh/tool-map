package de.htwg.seamless.app.routes

import spark.ModelAndView
import spark.Spark.*
import spark.template.handlebars.HandlebarsTemplateEngine

class PageRoutes {

    init { initializeRoutes() }

    private fun initializeRoutes() {
        get("/toolMap") { _, _ ->
            val jsonModel = ""



            HandlebarsTemplateEngine().render(
                    ModelAndView(jsonModel, "/map_template.hbs")
            )
        }
    }

}