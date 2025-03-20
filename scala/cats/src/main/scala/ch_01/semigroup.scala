package com.zibaldone.cats
package ch_01

import cats.Semigroup
import cats.instances.int.*
import cats.syntax.semigroup.*

// will throw an exception on empty iterables
extension [T: Semigroup](iterable: Iterable[T])
  // ex. use extension method
  def reduceIterable: T = iterable.reduce(_ |+| _)

final case class Expense(id: Long, amount: Double)

object Expense:
  // ex. support new type
  given Semigroup[Expense] = Semigroup.instance { (a, b) => Expense(a.id |+| b.id, a.amount |+| b.amount) }
