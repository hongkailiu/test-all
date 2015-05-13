package com.hongkailiu.test.app.tutorial.twitter.link3

import org.scalatest.FunSuite

class MyCollection$Test extends FunSuite {

  test("MyList"){
    println(MyList.numbers)
    assert(MyList.numbers !== null)
    assert(MyList.numbers(3)===4)

    println(MySet.numbers)
    assert(MyList.numbers !== null)
    assert(MyList.numbers(0)===1)

    println(MyTuple.hostPort)
    assert(MyTuple.hostPort !== null)
    assert(MyTuple.hostPort._1 === "localhost")
    assert(MyTuple.hostPort._2 === 80)

    println(MyTuple.hostPort1)
    assert(MyTuple.hostPort1 !== null)
    assert(MyTuple.hostPort1._1 === 1)
    assert(MyTuple.hostPort1._2 === 2)

    println(MyMap.map1)
    assert(MyMap.map1 !== null)
    assert(MyMap.map1(1) === 2)

    println(MyMap.map2)
    assert(MyMap.map2 !== null)

  }
}
