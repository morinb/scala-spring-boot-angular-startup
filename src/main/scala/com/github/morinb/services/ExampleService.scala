package com.github.morinb.services

import javax.persistence.EntityManager

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * @author Baptiste MORIN
 */
@Service
class ExampleService {

  @Autowired
  var em: EntityManager = _

  def getExampleDatas = em.createNamedQuery("ExampleData.findAll").getResultList

}
