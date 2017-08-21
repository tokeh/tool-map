package de.htwg.seamless.app.routes

import com.fasterxml.jackson.module.kotlin.readValue
import de.htwg.seamless.app.domain.*
import de.htwg.seamless.app.mapper
import spark.Spark.*

class ToolRoutes {

    init { this.initializeRoutes() }

    private fun initializeRoutes() {
        path("/tool") {

            // create
            post("/create") { req, res ->
                mapper.readValue<Tool>(req.body()).save()

                res.status(201)
                "Tool created"
            }

            // update
            put("/:name") { req, res ->
                val tool: Tool? = Tool.byId(req.params("name"))

                if (tool == null) {
                    res.status(404)
                    "Tool not found"

                } else {
                    tool.updateRating()
                    tool.update()
                    res.status(200)
                    "Tool updated"
                }
            }

            // delete
            delete("/:name") { req, res ->
                val tool: Tool? = Tool.byId(req.params("name"))

                if (tool == null) {
                    res.status(404)
                    "Tool not found"

                } else if (tool.delete()) {
                    res.status(200)
                    "Tool deleted"

                } else {
                    res.status(500)
                    "Deletion of tool failed"
                }
            }

            // read all
            get("/all", "application/json") { _, _ ->
                mapper.writeValueAsString(Tool.all())
            }

            // read single
            get("/:name", "application/json") { req, res ->
                val tool: Tool? = Tool.byId(req.params("name"))

                if (tool == null) {
                    res.status(404)
                    "Tool not found"

                } else {
                    mapper.writeValueAsString(tool)
                }
            }
        }
    }
}