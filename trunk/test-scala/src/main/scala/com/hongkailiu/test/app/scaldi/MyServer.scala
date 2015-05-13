package com.hongkailiu.test.app.scaldi

import scaldi.Injectable

/**
 * Created by hongkailiu on 2015-05-12.
 */
class MyServer(ip: String, port:Int) {

  def run():Unit={
    while (true) {
      Thread.sleep(1000)
      println("here i am: " + ip + "; " + port)
    }
  }
}

object MyApp extends App with Injectable {
  val ip : String = "3.3.3.3"
  val port : Int = 2552

  implicit val mainInjector =
    new MyModule(ip,port)

  implicit val myServer = inject[MyServer]
  myServer.run()

}
