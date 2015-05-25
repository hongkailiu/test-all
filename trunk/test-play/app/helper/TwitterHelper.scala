package helper

import java.util.List
import java.util.concurrent.{ExecutorService, Executors}

import models.Twitt
import twitter4j.{Status, QueryResult}

import scala.collection.JavaConversions._

/**
 * Created by ehongka on 5/25/15.
 */
object TwitterHelper {

  val pool: ExecutorService = Executors.newFixedThreadPool(1)
  val dwts = "#dwts"
  val myHandler = new MyHandler

  def start() = {

    pool.submit(new TwitterService(dwts, 3, 10 * 1000, myHandler))
  }
}


class MyHandler() extends ResultHandler {
  override def handle(queryResult: QueryResult): Unit = {

    val list: List[Status] = queryResult.getTweets
    //println(list)
    if (list!=null){
      //list.forEach(e => handleStatus(e))
      //list.foreach(s:Status => println(s))
      //implicit def javaIteratorToScalaIterator[A](it : java.util.Iterator[A]) = new Wrapper(it)
      //for (elem:List ) {

      //}
      for(x <- list) handleStatus(x)
      //numbers.foreach((i: Int) => i * 2)
      //}
    }

  }

  def handleStatus(status:Status): Unit = {
    println("=====a=======")
    println(status.getCreatedAt)
    println(status.getId)
    println(status.getText)
    println("=====b=======")
    //val twitt = new Twitt(status.getCreatedAt.toString, java.lang.Long.toString(status.getId), status.getText)
    //println(twitt)
  }
}
