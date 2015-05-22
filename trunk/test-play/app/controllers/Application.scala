package controllers

import play.api.mvc.{Action, Controller}

trait Application extends Controller {
  this: Controller =>
  def index = Action {
    Ok(views.html.index("Hello Play Framework"))
  }
}

object Application extends Controller with Application
