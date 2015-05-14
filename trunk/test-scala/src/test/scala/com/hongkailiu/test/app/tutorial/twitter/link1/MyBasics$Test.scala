package com.hongkailiu.test.app.tutorial.twitter.link1

import org.scalatest.FunSuite

/**
 * Created by ehongka on 5/14/15.
 */
class MyBasics$Test extends FunSuite {
  test("add") {
    val i:Int = MyBasics.adder(3,2)
    assert(5===i)

    val i2:Int = MyBasics.add2(3)
    assert(i2===i)

  }
}
