package de.htwg.seamless.app.domain.query

import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.domain.query.assoc.QAssocDimension
import de.htwg.seamless.app.domain.query.assoc.QAssocTool
import io.ebean.EbeanServer
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Property.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QProperty : TQRootBean<Property, QProperty> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QProperty(true)
  }

  lateinit var tools: QAssocTool<QProperty>
  lateinit var name: PString<QProperty>
  lateinit var dimensions: QAssocDimension<QProperty>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Property::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Property::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
