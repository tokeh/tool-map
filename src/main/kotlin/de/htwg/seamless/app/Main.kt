package de.htwg.seamless.app

import spark.Spark.*

fun main(args: Array<String>) {
    get("/hello") {req, res -> "Hello World!"}
}
