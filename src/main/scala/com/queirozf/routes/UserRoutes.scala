package com.queirozf.routes

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.queirozf.models.domain.User
import com.queirozf.models.forms.UserFormModel
import com.queirozf.models.marshallers.CustomMarshallers._


import scala.concurrent.Future
import scala.util.Random

/**
  * Created by felipe on 02/07/16.
  */
class UserRoutes(implicit val system: ActorSystem) {

  import system.dispatcher

  val mockData = List(
    User("1", "jdoe", Some("jdoe@example.com"), Some(23)),
    User("2", "msmith", None, Some(73)),
    User("3", "will", Some("william@example.com"), None),
    User("4", "phil", Some("philip@example.com"), Some(20)))

  def routes = {
    path("users") {
      get {
        complete {
          getAllUsers
        }
      } ~
      post {
          // the request is automatically rejected if the post
          // body (json entity) is not a valid userFormModel
          entity(as[UserFormModel]) { userForm =>
            complete {
              postNewUser(userForm)
            }
          }
        }
    }
  }


  private def getAllUsers: Future[List[User]] = {
    // simulating lengthy database querying operation
    Future {
      // by importing
      mockData
    }
  }

  private def postNewUser(userForm: UserFormModel) = {
    // simulate adding the user a database and returning the added values
    Future {
      val newId = Random.nextInt(100).toString
      val userModel = User(newId, userForm.username, userForm.email, userForm.age)

      // a tuple where the first element is a status code will also be
      // converted (unmarshalled) to json
      (StatusCodes.Created, userModel)
    }
  }

}
