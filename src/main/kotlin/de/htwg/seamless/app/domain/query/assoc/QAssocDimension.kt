package de.htwg.seamless.app.domain.query.assoc

import de.htwg.seamless.app.domain.Dimension
import de.htwg.seamless.app.domain.query.QDimension
import io.ebean.typequery.PInteger
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocDimension.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocDimension<R>(name: String, root: R) : TQAssocBean<Dimension,R>(name, root) {

  lateinit var properties: QAssocProperty<R>
  lateinit var index: PInteger<R>
  lateinit var name: PString<R>
  lateinit var description: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
