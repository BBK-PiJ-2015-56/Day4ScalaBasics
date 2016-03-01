package q4and5tailrecursion
/*
Given the following function:
def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
Design a tail-recursive version of factorial.
*/

object FactorialTest  {
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



object SumTest extends App {
  //QQQQQ) the pattern match method is just returning acc!??????????????
  def sumWithPatternMatch(f: Int => Int)(a: Int, b: Int): Int = {
    //iter will compute f(x) for every x and add it to teh accumulator, then return acc when x = b
    def iter(x: Int, acc: Int): Int = x + 1 match {
      case b => acc
      case _ => iter(x + 1, acc + f(x))
    }
    iter(a , 0)
  }

  def sumWithIf(f: Int => Int)(a: Int, b: Int): Int = {
    //iter will compute f(x) for every x and add it to teh accumulator, then return acc when x = b
    def iter(x: Int, acc: Int): Int = {
      if(x == b + 1) acc
      else iter(x + 1, acc + f(x))
    }
    iter(a , 0)
  }
  def double(x:Int) = 2*x
  println(double(3) + double(4) + double(5))
  println("testing sumWithPatternMatch")
  println(sumWithPatternMatch(double)(3 , 5))
  println("testing sumWithIf")
  println(sumWithIf(double)(3 , 5))

}
