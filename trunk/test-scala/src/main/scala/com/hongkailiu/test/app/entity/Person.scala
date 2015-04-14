package com.hongkailiu.test.app.entity

/**
 * Created by hongkailiu on 2015-04-13.
 */
class Person(val last:String,val first:String,val calc:Calculator) {
  override def toString = last + "," + first

  def add(x:Int, y:Int):Int={
    calc.add(x,y)
  }
}

object Person {
  def apply(last:String, first:String,calc:Calculator) = new Person(last,first,calc)
  def apply(last:String, first:String) = new Person(last,first,null)
  def apply(fullName:String) = {
    if (fullName.indexOf(',') != -1) {
      val parts = fullName.split(",",2)
      new Person(parts(0).trim,parts(1).trim,null)
    }
    else {
      val parts = fullName.split("\\s",2)
      new Person(parts(1),parts(0),null)
    }
  }
}

object PersonDemo extends App {
  val vick = Person("Vick","Mackey")
  val shane = Person("Vendrell, Shane")
  val ronnie = Person("Ronnie Gardocki")

  println(vick)
  println(shane)
  println(ronnie)
}
