package com.github.morinb.dtos

import javax.persistence.{NamedQuery, NamedQueries, Entity, Id}

import scala.beans.BeanProperty

/**
 *
 * @author Baptiste MORIN
 */
@Entity
@NamedQueries(Array[NamedQuery](
  new NamedQuery(name = "ExampleData.findAll", query = "SELECT e FROM com.github.morinb.dtos.ExampleData e")
))
class ExampleData {
  @Id
  @BeanProperty
  var key: String = _

  @BeanProperty
  var value: Double = _
}

object ExampleData {
  def apply(key: String, value: Double): ExampleData = {
    val e = new ExampleData
    e.setKey(key)
    e.setValue(value)
    e
  }
}

