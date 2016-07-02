package com.queirozf.models.marshallers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.queirozf.models.domain.User
import com.queirozf.models.forms.UserFormModel
import spray.json.DefaultJsonProtocol
/**
  * Created by felipe on 02/07/16.
  */
object CustomMarshallers extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val userFormFormat = jsonFormat3(UserFormModel)
  implicit val userFormat = jsonFormat4(User)

}
