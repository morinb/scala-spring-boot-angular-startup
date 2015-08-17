package com.github.morinb.controllers

import com.github.morinb.roster.ColumnModel
import com.github.morinb.services.ExampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RestController}

import scala.collection.JavaConversions

/**
 * Jackson JSON Conversion needs java object hence the use of JavaConversions helper.
 * @author Baptiste MORIN
 */
@RestController
class ExampleController {
  private[this] val model: List[ColumnModel] = List(
    new ColumnModel {
      override def getHeaderName: String = "Make"

      override def getField: String = "make"
    },
    new ColumnModel {
      override def getHeaderName: String = "Model"

      override def getField: String = "model"
    }, new ColumnModel {
      override def getHeaderName: String = "Price"

      override def getField: String = "price"
    }
  )


  @Autowired
  var service: ExampleService = _

  @RequestMapping(Array("/exampleData"))
  def example = service.getExampleDatas

  @RequestMapping(Array("/rosterModel/{columnId}"))
  def rosterModel(@PathVariable columnId: Integer): ColumnModel = model(columnId)

  @RequestMapping(Array("/rosterDatas"))
  def rosterDatas = JavaConversions.asJavaCollection(
    List(getRow("Toyota", "Celica", 35000),
      getRow("Ford", "Mondeo", 32000),
      getRow("Porsche", "Boxter", 72000))
  )

  private[this] def getRow(make: String, model: String, price: Integer) = JavaConversions.mapAsJavaMap(
    Map("make" -> make, "model" -> model, "price" -> price))

}
