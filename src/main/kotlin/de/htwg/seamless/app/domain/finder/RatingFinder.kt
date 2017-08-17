package de.htwg.seamless.app.domain.finder

import de.htwg.seamless.app.domain.Rating
import de.htwg.seamless.app.domain.query.QRating
import io.ebean.Finder
import java.util.UUID

open class RatingFinder : Finder<UUID,Rating> {

  val alias = QRating._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Rating::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Rating::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QRating {
     return QRating(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QRating {
     return QRating(db()).text()
  }
}
