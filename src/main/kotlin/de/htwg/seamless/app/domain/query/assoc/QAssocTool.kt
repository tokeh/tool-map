package de.htwg.seamless.app.domain.query.assoc

import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.domain.query.QTool
import io.ebean.typequery.PInteger
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocTool.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocTool<R>(name: String, root: R) : TQAssocBean<Tool,R>(name, root) {

  lateinit var toolName: PString<R>
  lateinit var description: PString<R>
  lateinit var properties: QAssocProperty<R>
  lateinit var links: QAssocLink<R>
  lateinit var ratings: QAssocRating<R>
  lateinit var rating: PInteger<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
