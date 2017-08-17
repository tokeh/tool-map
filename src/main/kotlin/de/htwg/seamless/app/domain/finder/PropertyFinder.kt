package de.htwg.seamless.app.domain.finder

import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.domain.query.QProperty
import io.ebean.Finder

open class PropertyFinder : Finder<String,Property> {

  val alias = QProperty._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Property::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Property::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QProperty {
     return QProperty(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QProperty {
     return QProperty(db()).text()
  }
}
