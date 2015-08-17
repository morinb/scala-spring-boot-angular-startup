package com.github.morinb

import javax.persistence.EntityManagerFactory

import com.github.morinb.dtos.ExampleData
import com.github.morinb.log.Logging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}

/**
 *
 * @author Baptiste MORIN
 */
@SpringBootApplication
class Application extends CommandLineRunner with Logging {

  @Autowired
  var emf: EntityManagerFactory = _

  override def run(args: String*): Unit = {
    LOG.info("Creating sample datas...")

    val em = emf.createEntityManager()
    em.getTransaction.begin()
    // Create an ExampleDate for each map entry and persist it
    Map(
      "One" -> 4,
      "Two" -> 5,
      "Three" -> 2,
      "Four" -> 7,
      "Five" -> 3,
      "Six" -> 6,
      "Seven" -> 1
    ).foreach {
      e => em.persist(ExampleData(e._1, e._2))
    }
    em.getTransaction.commit()
    LOG.info("Sample datas created.")


  }
}

object Application extends Logging {

  def main(args: Array[String]) {
    SpringApplication.run(classOf[com.github.morinb.Application], args: _*)
  }


}
