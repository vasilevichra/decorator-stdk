package com.stdk

import com.typesafe.config.ConfigFactory

import java.util.concurrent.atomic.AtomicInteger

package object decorator {

  trait Foo {
    def foo(): Unit = println("Foo")
  }

  trait Buz extends Foo {
    lazy val max: Int = ConfigFactory.load().getInt("max")
    private var fooInvocationCounter = new AtomicInteger(0)

    abstract override def foo(): Unit = {
      if (fooInvocationCounter.getAndIncrement() == max) throw new IllegalStateException(s"Limit in $max times for function call has been reached")
      else super.foo()
    }
  }

  class Bar extends Foo {
    override def foo(): Unit = println("Bar")
  }

}
