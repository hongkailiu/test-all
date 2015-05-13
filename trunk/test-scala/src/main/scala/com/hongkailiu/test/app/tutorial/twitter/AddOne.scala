package com.hongkailiu.test.app.tutorial.twitter

/**
 * Created by ehongka on 5/13/15.
 */
object addOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1
}


object AddOne extends App {
  println("addOne is:" + addOne(3))
}
