package com.hongkailiu.test.app.scaldi

import scaldi.Module

/**
 * Created by hongkailiu on 2015-05-12.
 */
class MyModule(ip:String, port:Int) extends Module {
  bind [MyServer] to new MyServer(inject [String] ('host), inject [Int] ('port))

  binding identifiedBy 'host to ip
  binding identifiedBy 'port to port
}



