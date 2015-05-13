package com.hongkailiu.test.app.tutorial.twitter

/**
 * Created by ehongka on 5/13/15.
 */
class AddTwo extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 2
}


object addTwo extends App {
  val plusTwo = new AddTwo()
  println("addOne is:" + plusTwo(3))
}
