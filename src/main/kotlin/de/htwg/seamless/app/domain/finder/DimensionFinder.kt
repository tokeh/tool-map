package de.htwg.seamless.app.domain.finder

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.query.QDimension
import io.ebean.Finder

open class DimensionFinder : Finder<String,Dimension> {

  val alias = QDimension._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Dimension::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Dimension::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QDimension {
     return QDimension(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QDimension {
     return QDimension(db()).text()
  }
}
