package com.queirozf.routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import com.queirozf.models.domain.User
import com.queirozf.models.forms.UserFormModel
import com.queirozf.models.marshallers.CustomMarshallers._


import scala.concurrent.Future

/**
  * Created by felipe on 02/07/16.
  */
class UserRoutes(implicit val system: ActorSystem) {

  import system.dispatcher

  def routes = {
    path("users") {
      get {
        complete {
          getAllUsers
        }
      } ~
        post {
          entity(as[UserFormModel]) { userForm =>
            complete {
              postNewUser(userForm)
            }
          }
        }
    }
  }

  private def getAllUsers: Future[List[User]] = {
    Future(List(User("adas","123213",None,None)))
  }

  private def postNewUser(userForm: UserFormModel): Future[User] = {
    Future(User("adas","123213",None,None))
  }

}
