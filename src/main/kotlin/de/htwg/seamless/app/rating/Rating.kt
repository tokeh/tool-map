package de.htwg.seamless.app.rating

import java.time.LocalDateTime
import java.util.*

data class Rating(val id: UUID, val context: String, val text: String,
                  val stars: Int, val date: LocalDateTime, val creator: String)