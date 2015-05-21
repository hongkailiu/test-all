package models

/**
 * Created by ehongka on 5/21/15.
 */
case class Person(id: Long, name: String)

object Person {

  var list: List[Person] = {
    List(
      Person(3, "hk"),
      Person(6, "elle")
    )
  }

  def save(person: Person) = {
    list = list ::: List(person)
  }
}
