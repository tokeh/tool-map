package de.htwg.seamless.app.domain.query

import de.htwg.seamless.app.domain.Link
import io.ebean.EbeanServer
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Link.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QLink : TQRootBean<Link, QLink> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QLink(true)
  }

  lateinit var linkText: PString<QLink>
  lateinit var name: PString<QLink>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Link::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Link::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
