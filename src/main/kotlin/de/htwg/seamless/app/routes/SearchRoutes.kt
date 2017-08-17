package de.htwg.seamless.app.routes

import com.fasterxml.jackson.module.kotlin.readValue
import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.mapper
import de.htwg.seamless.app.util.SearchKeywords
import spark.Spark.*

class SearchRoutes {

    init { initializeRoutes() }

    fun initializeRoutes() {
        get("/search") { req, _ ->
            val searchKeywords: SearchKeywords = mapper.readValue<SearchKeywords>(req.body())
            val tools = mutableListOf<Tool>()
            searchKeywords.properties.forEach { tools.addAll(Tool.where().properties.name.contains(it).findList()) }
            searchKeywords.dimensions.forEach { tools.addAll(Tool.where().properties.dimensions.name.contains(it).findList()) }

            mapper.writeValueAsString(tools)
        }
    }
}