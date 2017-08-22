package de.htwg.seamless.app.domain.query.assoc

import de.htwg.seamless.app.domain.Rating
import de.htwg.seamless.app.domain.query.QRating
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PString
import io.ebean.typequery.PUuid
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocRating.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocRating<R>(name: String, root: R) : TQAssocBean<Rating,R>(name, root) {

  lateinit var uuid: PUuid<R>
  lateinit var text: PString<R>
  lateinit var context: PString<R>
  lateinit var author: PString<R>
  lateinit var stars: PInteger<R>
  lateinit var date: PLocalDate<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
