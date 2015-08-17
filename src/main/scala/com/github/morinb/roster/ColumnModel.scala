package com.github.morinb.roster

/**
 *
 * @author Baptiste MORIN
 */
trait ColumnModel extends Serializable {
  def getHeaderName: String

  def getField: String
}
