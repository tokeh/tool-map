package de.htwg.seamless.app.domain.query

import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.domain.query.assoc.QAssocLink
import de.htwg.seamless.app.domain.query.assoc.QAssocProperty
import de.htwg.seamless.app.domain.query.assoc.QAssocRating
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Tool.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QTool : TQRootBean<Tool, QTool> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QTool(true)
  }

  lateinit var toolName: PString<QTool>
  lateinit var description: PString<QTool>
  lateinit var properties: QAssocProperty<QTool>
  lateinit var links: QAssocLink<QTool>
  lateinit var ratings: QAssocRating<QTool>
  lateinit var rating: PInteger<QTool>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Tool::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Tool::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
