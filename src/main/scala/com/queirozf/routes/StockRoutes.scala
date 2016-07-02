package com.queirozf.routes

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import com.queirozf.models.domain.User
import com.queirozf.models.marshallers.CustomMarshallers._

import scala.concurrent.Future

/**
  * Created by felipe.almeida@vtex.com.br on 29/06/16.
  */
class StockRoutes(implicit val system: ActorSystem) {

  import system.dispatcher
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(system))

  private val baseUrl = """https://www.quandl.com/api/v3/datasets/wiki/%s.json?limit=1&end_date=%s"""

  def routes = {
    path("stocks" / Segment){ company =>
      get{
        complete {
          getLatestPrice(company)
        }
      }
    }
  }

  private def getLatestPrice(company: String): Future[String] = {

    // see this link for more info on dealing with dates: http://queirozf.com/entries/java-time-api-examples-and-reference-for-dealing-with-date-time-on-java-8
    val todaysDate = ZonedDateTime.now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    val fullUrl = baseUrl.format(company,todaysDate)

    val request = HttpRequest(method = HttpMethods.GET,uri = fullUrl)

    Http().singleRequest(request).flatMap{ response =>
      Unmarshal(response.entity).to[String]
    }

  }

}
