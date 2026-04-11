package com.zibaldone.zio
package ch_01

import zio.*

final case class UserSubscription(emailService: EmailService, userDatabase: UserDatabase)
final case class UserDatabase(connectionPool: ConnectionPool)
final case class ConnectionPool(nConnections: Int)
final case class EmailService()

object ConnectionPool:
  
  // ZLayers are memoized by default unless explicitly marked as fresh
  val live: ULayer[ConnectionPool] = ZLayer.succeed(ConnectionPool(10))

object UserDatabase:

  // manual vertical composition
  // ULayer[UserDatabase] = ConnectionPool.live >>> UserDatabase.live
  val live: URLayer[ConnectionPool, UserDatabase] = ZLayer.fromFunction(UserDatabase.apply)

object EmailService:

  val live: ULayer[EmailService] = ZLayer.succeed(EmailService())

object UserSubscription:

  // manual horizontal composition
  // ULayer[UserSubscription] = (ULayer[UserDatabase] ++ EmailService.live) >>> UserSubscription.live
  val live: URLayer[EmailService & UserDatabase, UserSubscription] = ZLayer.fromFunction(UserSubscription.apply)

def manualDependencyInjection(zio: URIO[UserSubscription, Unit]): UIO[Unit] =
  val liveUserDatabase: ULayer[UserDatabase] = ConnectionPool.live >>> UserDatabase.live
  zio.provide((liveUserDatabase ++ EmailService.live) >>> UserSubscription.live)

def semiAutomaticDependencyInjection(application: URIO[UserSubscription, Unit]): UIO[Unit] =
  application.provide(
    ConnectionPool.live,
    UserDatabase.live,
    EmailService.live,
    UserSubscription.live
    // ZLayer.Debug.tree
  )
