package de.htwg.seamless.app.domain.finder

import de.htwg.seamless.app.domain.Tool
import de.htwg.seamless.app.domain.query.QTool
import io.ebean.Finder

open class ToolFinder : Finder<String,Tool> {

  val alias = QTool._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Tool::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Tool::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QTool {
     return QTool(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QTool {
     return QTool(db()).text()
  }
}
