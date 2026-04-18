package com.zibaldone.cats
package ch_02

import cats.Eval

def mixedEvaluation: Eval[Int]                   =
  for
    a <- Eval.now(40)   // val
    b <- Eval.later(1)  // memo
    c <- Eval.always(1) // def
  yield a + b + c

// ex. implement defer such that defer(Eval.now) does NOT run side effects
def defer[A](expr: => Eval[A]): Eval[A]          =
  for
    _    <- Eval.later(())
    eval <- expr
  yield eval

// ex. reverse linked list
def reverseEval[A](list: List[A]): Eval[List[A]] = list match
  case Nil          => Eval.now(Nil)
  case head :: tail => Eval.defer { reverseEval(tail).map(_ :+ head) } // stack-safe
