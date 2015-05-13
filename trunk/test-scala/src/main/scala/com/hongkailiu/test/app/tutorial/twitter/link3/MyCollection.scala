package com.hongkailiu.test.app.tutorial.twitter.link3

/**
 * Created by ehongka on 5/13/15.
 */
object MyList {
  val numbers = List(1, 2, 3, 4)
}


object MySet {
  val numbers = Set(1, 1, 2)
}

object MyTuple {
  val hostPort = ("localhost", 80)
  val hostPort1 = 1->2
}

object MyMap {
  val map1 = Map(1 -> 2)
  val map2 =  Map("foo" -> "bar")
  map2+("a"->"b")
}

object MyOption {
  val map1 = Map(1 -> 2, 3->4)
  val op: Option[Int] = map1.get(1)
}
