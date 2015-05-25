package helper

import play.api.Logger

/**
 * Created by ehongka on 5/25/15.
 */
class TwitterService extends Runnable {


  def run() {
    try {
      while (true) {
        // TODO
        Thread sleep 10 * 1000
        Logger.info("start============")
      }
    } catch {
      case e: Exception => {
        Logger.error(e.getMessage)
      }
    } finally {

    }
  }
}
