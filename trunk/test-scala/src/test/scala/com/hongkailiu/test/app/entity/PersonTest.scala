package com.hongkailiu.test.app.entity


import org.scalatest.{BeforeAndAfter, FunSuite}
import org.mockito.Mockito
/**
 * Created by hongkailiu on 2015-04-13.
 */
class PersonTest extends FunSuite with BeforeAndAfter {



  test("aaa"){
    val mockCalc:Calculator = Mockito.mock(classOf[Calculator])
    val vick = Person("Vick","Mackey",mockCalc)
    Mockito.when(mockCalc.add(1,2)).thenReturn(3);
    val m = vick.add(1,2)
    assert(3 === m)
  }

  before {
    println("before")
  }

  after {
    println("after")
  }
}
