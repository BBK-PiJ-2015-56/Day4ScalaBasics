package q3sigoodenough


object One {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(square(guess) - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)
  def square(x: Double) = x * x
  def abs(x: Double) = if (x > 0) x else -x
}
object testGuesses extends App{
  println("starting sqrtIter")
  println(One.sqrtIter(9.0 , 81))
}
/*
The isGoodEnough test is not very precise for small numbers and might lead to non-termination (why?).
Design a different version of isGoodEnough which does not have
these problems.


eg1. guess = 3 , x = 12
then check if its good enough: abs(9-12) = 3 so not good enough
so improve guess: x/guess = 12/3 = 4;  guess + 4 = 7;  7/2 = 3.5

eg2.  guess = 9 , x = 10
then check   abs(10-81) = 71   so not good enough
improve: x/guess = 10/9 = 1.111;   guess + 1.111 = 10.111;  10.111/2 = 5.06....

doesnt make sense!!!!
*/