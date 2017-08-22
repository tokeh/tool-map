package de.htwg.seamless.app.domain.query.assoc

import de.htwg.seamless.app.domain.Link
import de.htwg.seamless.app.domain.query.QLink
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocLink.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocLink<R>(name: String, root: R) : TQAssocBean<Link,R>(name, root) {

  lateinit var linkText: PString<R>
  lateinit var name: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
