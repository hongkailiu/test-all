package com.hongkailiu.test.scala.book.chaptere1

import java.math.BigInteger

object ExampleInChapter1 {
  def main(args: Array[String]) {
    // 失去了自动补全函数定义的功能
    exampleP50();
    println("factorial: " + factorial(30))
    println("factorial2 with java class: " + factorial2(new BigInteger("30")))
    println("getUpperCaseChar: " + getUpperCaseChar("niNhao"))
  }

  def exampleP50() {
    // 不用new, 不用声明类型，不用分号
    // 在eclipse里看sdk的源码实现是如此的方便，F3
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))
  }

  def factorial(x: BigInt): BigInt =
    if (x == 0) 1 else x * factorial(x - 1)

  def factorial2(x: BigInteger): BigInteger =
    if (x == BigInteger.ZERO)
      BigInteger.ONE
    else
      x.multiply(factorial2(x.subtract(BigInteger.ONE)))

  def getUpperCaseChar(string : String): Boolean =
    string.exists(_.isUpper)

}