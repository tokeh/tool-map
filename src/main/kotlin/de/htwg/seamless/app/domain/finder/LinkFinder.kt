package de.htwg.seamless.app.domain.finder

import de.htwg.seamless.app.domain.Link
import de.htwg.seamless.app.domain.query.QLink
import io.ebean.Finder

open class LinkFinder : Finder<String,Link> {

  val alias = QLink._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Link::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Link::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QLink {
     return QLink(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QLink {
     return QLink(db()).text()
  }
}
