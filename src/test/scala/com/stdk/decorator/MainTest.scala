package com.stdk.decorator

import com.stdk.decorator.Main.foo
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MainTest extends AnyWordSpec with Matchers {

  "Invocation of function foo() by MAX times" should {
    "executed regularly" in {
      (1 to max) foreach (x => foo())
    }
  }

  "Invocation of function foo() by MAX+1 times" should {
    "throw the expected exception" in {
      assertThrows[IllegalStateException] {
        (1 to max + 1) foreach (x => foo())
      }
    }
  }

}
