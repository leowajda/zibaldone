package com.zibaldone.cats
package hierarchy

trait Monoid[A] extends Semigroup[A]:
  def empty: A
  
