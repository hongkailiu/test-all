package helper

import play.api.Logger
import twitter4j.{QueryResult, Query, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by ehongka on 5/25/15.
 */
class TwitterService(hashTag:String, count:Int, interval: Long , resultHandler: ResultHandler) extends Runnable {

  val cb = new ConfigurationBuilder()
  /*cb.setDebugEnabled(true)
    .setOAuthConsumerKey("uxHMOFhz4LQNzDU1OPl6ICFry")
    .setOAuthConsumerSecret("p99mPF0nsXW9Gw8BtPWY9CcOuMO9yKG16IenPuBlP0MdcBgMzw")
    .setOAuthAccessToken("3297829109-CylqTlwceyNEMm72IwcmyBBgAXdvEEwzkvCUxtq")
    .setOAuthAccessTokenSecret("jpyc5JQHRB47mFDZdxRk13EkZx5clZNBJa7a0LhMLX8XF")*/
  cb.setDebugEnabled(true)
    .setOAuthConsumerKey("Eq7V4ZPpMiF3i2saGBJkqFsVJ")
    .setOAuthConsumerSecret("cS1odMViNWmeA6ixCY2ar8pC69k9IrMfwwNS9zDS4jmBItuXTS")
    .setOAuthAccessToken("37640155-Rn3ECsPwrWcvllHrKgRDBI1nQrIoxUW0cfUKP3z37")
    .setOAuthAccessTokenSecret("1hkGGM7IFrISjQFthjNywr9B3IlEAWaEfnInDvZyDHRn2")
  val tf = new TwitterFactory(cb.build())
  val twitter = tf.getInstance()
  //val dwtsQuery = new Query("#dwts")
  val dwtsQuery = new Query("#" + hashTag)

  def run() {
    try {
      while (true) {
        // TODO
        Logger.info("start============")
        dwtsQuery.count(count)
        val queryResult = twitter.search(dwtsQuery)
        resultHandler.handle(queryResult)
        Thread sleep interval
      }
    } catch {
      case e: Exception => {
        Logger.error(e.getMessage)
      }
    } finally {

    }
  }
}


trait ResultHandler {
  def handle(queryResult: QueryResult)
}
