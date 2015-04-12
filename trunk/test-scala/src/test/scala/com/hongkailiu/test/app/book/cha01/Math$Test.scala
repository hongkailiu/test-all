package com.hongkailiu.test.app.book.cha01

import org.scalatest.FunSuite

/**
 * Created by hongkailiu on 2015-04-11.
 */
class Math$Test extends FunSuite {
  test("max on 3,2") {
    val m = Math.max(3, 2)
    assert(m === 3)
  }
}