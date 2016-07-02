package com.queirozf

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import com.queirozf.routes.{UserRoutes, StockRoutes}

/**
  * Created by felipe.almeida@vtex.com.br on 29/06/16.
  */
object Main extends App{

  implicit val system = ActorSystem("main-actor-system")
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(system))
  implicit val ec = system.dispatcher

  // this is one way of dividing route responsibilities among several classes
  val stockRoutes = (new StockRoutes).routes
  val userRoutes = (new UserRoutes).routes


  def healthCheckRoute = {
    path("healthcheck"){
      get{
        complete("Ok")
      }
    }
  }

  val allRoutes = healthCheckRoute ~ stockRoutes ~ userRoutes

  // here the server is started
  Http().bindAndHandle(allRoutes, "0.0.0.0", 5000)

}
