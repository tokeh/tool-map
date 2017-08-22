package de.htwg.seamless.app.domain.query

import de.htwg.seamless.app.domain.Rating
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PString
import io.ebean.typequery.PUuid
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Rating.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QRating : TQRootBean<Rating, QRating> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QRating(true)
  }

  lateinit var uuid: PUuid<QRating>
  lateinit var text: PString<QRating>
  lateinit var context: PString<QRating>
  lateinit var author: PString<QRating>
  lateinit var stars: PInteger<QRating>
  lateinit var date: PLocalDate<QRating>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Rating::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Rating::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
