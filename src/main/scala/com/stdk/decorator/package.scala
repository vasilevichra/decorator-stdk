package com.stdk

import com.typesafe.config.ConfigFactory

import java.util.concurrent.atomic.AtomicInteger

package object decorator {

  private val conf = ConfigFactory.load()
  val max: Int = conf.getInt("max")
  private var counter: AtomicInteger = new AtomicInteger(0)

  implicit def invocationCount: AtomicInteger =
    if (counter.getAndIncrement() == max) throw new IllegalStateException(s"Limit in $max times for function call has been reached")
    else counter

}
