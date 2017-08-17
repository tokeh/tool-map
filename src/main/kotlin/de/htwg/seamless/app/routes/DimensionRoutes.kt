package de.htwg.seamless.app.routes

import com.fasterxml.jackson.module.kotlin.readValue
import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.mapper
import de.htwg.seamless.app.util.Util
import spark.Spark.*

class DimensionRoutes {

    init { initializeRoutes() }

    fun initializeRoutes() {
        path("/dimension") {

            // create
            post("/create") { req, res ->
                mapper.readValue<Dimension>(req.body()).save()

                res.status(201)
                "Dimension created"
            }

            // update
            put("/:name") { req, res ->
                mapper.readValue<Dimension>(req.body()).update()

                val dimension: Dimension? = Dimension.byId(req.params("name"))

                if (dimension == null) {
                    res.status(404)
                    "Dimension not found"

                } else {
                    dimension.update()
                    res.status(200)
                    "Dimension updated"
                }
            }

            // delete
            delete("/:name") { req, res ->
                val dimension: Dimension? = Dimension.byId(req.params("name"))

                if (dimension == null) {
                    res.status(404)
                    "Dimension not found"

                } else if (dimension.delete()) {
                    res.status(200)
                    "Dimension deleted"

                } else {
                    res.status(500)
                    "Deletion of dimension failed"
                }
            }

            // read all
            get("/all", "application/json") { _, _ ->
                mapper.writeValueAsString(Dimension.all())
            }

            // read single
            get("/:name", "application/json") { req, res ->
                val dimension: Dimension? = Dimension.byId(req.params("name"))

                if (dimension == null) {
                    res.status(404)
                    "Dimension not found"

                } else {
                    mapper.writeValueAsString(dimension)
                }
            }
        }
    }
}