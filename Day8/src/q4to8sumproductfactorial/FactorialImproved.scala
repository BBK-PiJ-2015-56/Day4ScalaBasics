package q4to8sumproductfactorial

//q6
/*
Write a function product that computes the product of the values of a function at
points over a given range.
*/

// Had same problem with matching approach - managed to sort it you need the condition z==b
//you cant just refer to b, as it treats it like any variable and matched it to every integer
object FactorialImprovedTest {
  def productWithMatch(f: Int => Int)(a:Int , b:Int):Int = {
    def iter(x:Int , acc:Int):Int = x - 1 match {
      case z if (z==b) => acc
      case _ => iter(x+1 , acc * f(x))
    }
    iter(a , 1)
  }
  def product(f: Int => Int)(a:Int , b:Int):Int = {
    def iter(x:Int , acc:Int):Int =  {
      if(x-1 == b) acc
      else iter(x+1 , acc * f(x))
    }
    iter(a , 1)
  }
  println("testing product")
  println(product(x => x + 1)(2 , 5))
  println("testing productWithMatch")
  println(productWithMatch(x => x + 1)(2 , 5))

  /*
  7. Write factorial in terms of product.
   */
  def factorialBetter(n:Int):Int = {
    product(m => m)(1, n)
  }

  println("testing factorialBetter")
  println("factorial 3 is " + factorialBetter(3))
  println("factorial 4 is " + factorialBetter(4))
  println("factorial 0 is " + factorialBetter(0))
}

