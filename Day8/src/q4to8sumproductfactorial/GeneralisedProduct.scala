package q4to8sumproductfactorial



// note: the word product is used here in the pure mathematical sense,
//to mean a general function that takes two values of a set
// and returns a third value of a set according to a given operation
object GeneralisedProductTest extends App {
  def generalisedProduct(f:Int => Int)(g:(Int,Int) =>Int , acc:Int)(a:Int , b:Int):Int = {
    def iter(g:(Int,Int) =>Int)(x:Int , acc:Int):Int = x - 1 match{
      case z if(z==b) => acc
      case _ => iter(g)(x+1 , g(acc , f(x)) )
    }
    iter(g)(a , acc )
  }

  //test genProduct - it works!
  println("testing genProduct expected 360")
  println(generalisedProduct(x => x+1)((p , q) => p * q , 1)(2,5))

  // AP: extension - do this with parameterized types
}
