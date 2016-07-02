package com.queirozf.models.domain

/**
  * Created by felipe on 02/07/16.
  */
case class User(id: String, username: String, email: Option[String], age: Option[Int])
