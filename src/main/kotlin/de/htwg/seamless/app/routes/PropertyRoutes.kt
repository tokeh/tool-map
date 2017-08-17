package de.htwg.seamless.app.routes

import com.fasterxml.jackson.module.kotlin.readValue
import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.mapper
import de.htwg.seamless.app.util.Util
import spark.Spark.*

class PropertyRoutes {

    init { initializeRoutes() }

    fun initializeRoutes() {
        path("/property") {

            // create
            post("/create") { req, res ->
                mapper.readValue<Property>(req.body()).save()

                res.status(201)
                "Property created"
            }

            // update
            put("/:name") { req, res ->
                mapper.readValue<Property>(req.body()).update()

                val property: Property? = Property.byId(req.params("name"))

                if (property == null) {
                    res.status(404)
                    "Property not found"

                } else {
                    property.update()
                    res.status(200)
                    "Property updated"
                }
            }

            // delete
            delete("/:name") { req, res ->
                val property: Property? = Property.byId(req.params("name"))

                if (property == null) {
                    res.status(404)
                    "Property not found"

                } else {
                    if (property.delete()) {
                        res.status(200)
                        "Property deleted"

                    } else {
                        res.status(500)
                        "Deletion of property failed"
                    }
                }
            }

            // read all
            get("/all", "application/json") { _, _ ->
                mapper.writeValueAsString(Property.all())
            }

            // read single
            get("/:name", "application/json") { req, res ->
                val property: Property? = Property.byId(req.params("name"))

                if (property == null) {
                    res.status(404)
                    "Property not found"

                } else {
                    mapper.writeValueAsString(property)
                }
            }
        }
    }
}