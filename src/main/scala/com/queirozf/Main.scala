package com.queirozf

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}

/**
  * Created by felipe.almeida@vtex.com.br on 29/06/16.
  */
object Main extends App{

  implicit val system = ActorSystem("main-actor-system")
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(system))
  implicit val ec = system.dispatcher

  def routes = {
    path("healthcheck"){
      get{
        complete("Ok")
      }
    }
  }

  Http().bindAndHandle(routes, "0.0.0.0", 5000)

}
