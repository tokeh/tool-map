package de.htwg.seamless.app

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import de.htwg.seamless.app.routes.*
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import spark.Spark.*
import java.io.FileInputStream
import java.io.IOException
import java.util.*

// JSON mapper initialization
val mapper = jacksonObjectMapper()

fun main(args: Array<String>) {

    initialize()

    // Ebean configuration
    val properties: Properties = Properties()
    properties.load(FileInputStream("src/main/resources/ebean.properties"))
    val config = ServerConfig()
    config.name = "tool_map"
    config.isDefaultServer = true
    config.loadFromProperties(properties)
    EbeanServerFactory.create(config)

    // Spark routes initialization
    staticFiles.location("/static")
    ToolRoutes()
    DimensionRoutes()
    PropertyRoutes()
    FilterRoutes()
    PageRoutes()

    // Exception handling
    exception(JsonParseException::class.java, { ex, _, response ->
        response.status(500)
        response.body("JSON parsing failed: " + ex.message)
    })

    exception(JsonMappingException::class.java, { ex, _, response ->
        response.status(500)
        response.body("JSON mapping failed: " + ex.message)
    })

    exception(IOException::class.java, { ex, _, response ->
        response.status(500)
        response.body("Processing of request failed: " + ex.message)
    })
}

fun initialize() {
    mapper.registerModule(JavaTimeModule())
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
}