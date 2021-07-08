package com.stdk.decorator

import java.util.concurrent.atomic.AtomicInteger

object Main extends App {

  def foo()(implicit ic: AtomicInteger): String = "invocation"

  (1 to 5) foreach (x => println(s"${x}-th ${foo()}"))

}
