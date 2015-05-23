package controllers

import org.scalatest.{FunSuite, FlatSpec, Matchers}
import org.scalatestplus.play._
import play.api.mvc.Controller
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

/**
 * Created by hongkailiu on 2015-05-23.
 */
class ApplicationTest extends FunSuite {

  class TestController() extends Controller with controllers.Application

  test("dummy test") {
    new WithApplication {
      val controller = new TestController()
      val result: Future[play.api.mvc.Result] = controller.index().apply(FakeRequest())
      assert(status(result)===OK)
    }
  }


}
