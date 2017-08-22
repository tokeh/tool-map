package de.htwg.seamless.app.domain.query.assoc

import de.htwg.seamless.app.domain.Property
import de.htwg.seamless.app.domain.query.QProperty
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocProperty.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocProperty<R>(name: String, root: R) : TQAssocBean<Property,R>(name, root) {

  lateinit var tools: QAssocTool<R>
  lateinit var name: PString<R>
  lateinit var dimensions: QAssocDimension<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
