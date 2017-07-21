package de.htwg.seamless.app.tool

import de.htwg.seamless.app.property.Property
import de.htwg.seamless.app.link.Link
import de.htwg.seamless.app.rating.Rating

data class Tool(val name: String, val description: String, val links: List<Link>,
                val ratings: List<Rating>,  val properties: List<Property>)