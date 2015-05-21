package controllers

import play.api.mvc.{Action, Controller}

object Persons extends Controller {
  def list = Action {
    Ok(views.html.index("Hello Play Framework: list"))
  }

  def show(id:Long) = Action {
    Ok(views.html.index("Hello Play Framework: show: " + id))
  }
}
