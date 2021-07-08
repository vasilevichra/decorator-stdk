package com.stdk.decorator

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MainTest extends AnyWordSpec with Matchers {

  "Invocation of function foo() by MAX times" should {
    "executed regularly" in {
      val barDecorated = new Bar() with Buz
      (1 to barDecorated.max) foreach (x => barDecorated.foo())
    }
  }

  "Invocation of function foo() by MAX+1 times" should {
    "throw the expected exception" in {
      assertThrows[IllegalStateException] {
        val barDecorated = new Bar() with Buz
        (1 to barDecorated.max + 1) foreach (x => barDecorated.foo())
      }
    }
  }

}
