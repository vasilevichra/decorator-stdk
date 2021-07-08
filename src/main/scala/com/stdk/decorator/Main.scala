package com.stdk.decorator

object Main extends App {

  val barDecorated = new Bar() with Buz

  (1 to barDecorated.max + 1) foreach (x => barDecorated.foo())

}
