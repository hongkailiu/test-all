import org.scalatest._

class HelloSpec extends FlatSpec with ShouldMatchers {
  "Hello" should "have tests" in {
    true should be === true
  }
}
