package com.zibaldone.cats
package hierarchy

trait Semigroup[A]:
  def combine(x: A, y: A): A
