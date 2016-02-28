package q4and5tailrecursion
/*
Given the following function:
def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
Design a tail-recursive version of factorial.
*/

object FactorialTest extends App {
  def factorial(n: Int , acc:Int):Int = n match{
    case n if n == 0 => acc
    case _ => factorial(n-1 , acc * n )
  }
  println(factorial(3 , 1))
  println(factorial(0 , 1))
}
//Q5
/*
Can you write a tail-recursive version of a function sum, that computes the sum of
the values of a function at points over a given range, by filling in the ???’s?
def sum(f: Int => Int)(a: Int, b: Int): Int = {
def iter(a: Int, result: Int): Int = {
if (???) ???
else iter(???, ???)
}
iter(??, ??)
}
 */












/*


object SumTest extends App {

  def sum(f: Int => Int)(a: Int, b: Int): Int = match a {
    def iter = f(a)
    case b => 0
    case _ => sum(f)(a + 1 , b)
  }
}
*/