package helper

import java.util.concurrent.{Executors, ExecutorService}

import play.api.Logger

/**
 * Created by ehongka on 5/25/15.
 */
object TwitterHelper {

  val pool: ExecutorService = Executors.newFixedThreadPool(1)

  def start() ={
    pool.submit(new TwitterService)
  }
}
