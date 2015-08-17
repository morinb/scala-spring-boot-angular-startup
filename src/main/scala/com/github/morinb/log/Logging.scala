package com.github.morinb.log

import org.slf4j.{LoggerFactory, Logger}

/**
 *
 * @author Baptiste MORIN
 */
trait Logging { self =>
  // no need to specify a specific logback.xml file , we'll use the spring's one, once spring will load.
  lazy val LOG: Logger = LoggerFactory.getLogger(self.getClass)
}
