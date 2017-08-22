package de.htwg.seamless.app.domain.query

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.query.assoc.QAssocProperty
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Dimension.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QDimension : TQRootBean<Dimension, QDimension> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QDimension(true)
  }

  lateinit var properties: QAssocProperty<QDimension>
  lateinit var index: PInteger<QDimension>
  lateinit var name: PString<QDimension>
  lateinit var description: PString<QDimension>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Dimension::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Dimension::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
