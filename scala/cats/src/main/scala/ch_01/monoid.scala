package com.zibaldone.cats
package ch_01

import cats.Monoid
import cats.instances.int.*
import cats.syntax.monoid.*

extension [T: Monoid as monoid](iterable: Iterable[T])
  // ex. implement combineFold
  def foldIterable: T = iterable.fold(monoid.empty)(_ |+| _)

// ex. combine a list of phonebooks as Map[String, Int]
import cats.instances.map.*

val phoneBookA = Map[String, Int]("a" -> 1, "b" -> 2)
val phoneBookB = Map[String, Int]("c" -> 3, "a" -> 2)
val phoneBookC = List(phoneBookA, phoneBookB).foldIterable // "a" -> 3

// ex. shopping cart and online stores
final case class ShoppingCart(items: List[String], total: Double)

object ShoppingCart:

  given Monoid[ShoppingCart] = Monoid.instance(
    emptyValue = ShoppingCart(Nil, 0.0),
    cmb = (a, b) => ShoppingCart(a.items |+| b.items, a.total |+| b.total)
  )

  def checkout(shoppingCarts: List[ShoppingCart]): ShoppingCart = shoppingCarts.foldIterable
