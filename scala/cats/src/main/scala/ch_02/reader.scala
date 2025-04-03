package com.zibaldone.cats
package ch_02

import cats.data.Reader

final case class Configuration(dbUsername: String, dbPassword: String, host: String, port: Int)

final case class DbConnection(username: String, password: String)

object DbConnection:

  val reader: Reader[Configuration, DbConnection] = Reader { conf => DbConnection(conf.dbUsername, conf.dbPassword) }

final case class EmailService(host: String, port: Int, dbConnection: DbConnection)

// reader is a Kleisli so it chains higher-order functions
object EmailService:

  // ex. email service
  val reader: Reader[Configuration, EmailService] =
    for
      conf   <- Reader[Configuration, Configuration](identity)
      dbConn <- DbConnection.reader
    yield EmailService(conf.host, conf.port, dbConn)
