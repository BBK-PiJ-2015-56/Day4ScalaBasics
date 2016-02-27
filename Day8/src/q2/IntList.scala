package q2

sealed trait IntList
{
  def length: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => 1 + tl.length
    }

  def double: IntList =
    this match {
      case End => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
  def product: Int =
    this match {
      case End => 1
      case Pair(hd, tl) => hd * tl.product
    }
  def sum: Int = this match {
    case End => 0
    case Pair(hd, tl) => hd + tl.sum
  }
  def fold(f:(Int,Int) => Int , unitVal:Int):Int = {
    this match{
      case End => unitVal
      case Pair(h,t) => f(h , t.fold(f , unitVal))
    }
  }
  //re-implementation to use with fold
  def newSum(x:Int , y:Int) = x + y
  def newProduct(x:Int , y:Int) = x * y
  def newLength(x:Int , y: Int) = 1 + y // this doesn't feel right intuitively
  // - why does it need to take two args - isn't the function just  x => newSum(x , 1)   ????
/* Q)??????????????????????????????????????????????????????????????????????????????????????????
  def generalFold[A](f:(Int) => Int , unitVal:A):A = this match{
    case End => unitVal
    case Pair(h,t) => f(h , t.generalFold(f , unitVal)) // need to think about it
  }
}
*/

final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList


object TestFold extends App {
  val emptyList: IntList = End
  val list: IntList = Pair(1, Pair(3, Pair(5, Pair(7, End))))
  println(emptyList)
  println(list)
  //(a) Rename this function to fold, which is the name it is usually known as, and
  //complete the implementation.
  //testing with sum, product and length as anonymous functions
  println("testing sum")
  println(emptyList.sum)
  println(list.sum)
  println(emptyList.fold((x, y) => x + y, 0))
  println(list.fold((x, y) => x + y, 0))
  println("testing product")
  println(emptyList.product)
  println(list.product)
  println(emptyList.fold((x, y) => x * y, 1))
  println(list.fold((x, y) => x * y, 1))
  println("testing length")
  println(emptyList.length)
  println(list.length)
  println(emptyList.fold((x, y) => 1 + y, 0))
  println(list.fold((x, y) => 1 + y, 0))

  //(b) Now reimplement sum, length, and product in terms of fold.
  //testing fold using defined functions
  println("testing newSum")
  println(emptyList.sum)
  println(list.sum)
  println(emptyList.fold(emptyList.newSum, 0))
  println(list.fold(list.newSum, 0))
  println("testing newProduct")
  println(emptyList.product)
  println(list.product)
  println(emptyList.fold(emptyList.newProduct, 1))
  println(list.fold(list.newProduct, 1))
  println("testing newLength")
  println(emptyList.length)
  println(list.length)
  println(emptyList.fold(emptyList.newLength, 0))
  println(list.fold(list.newLength, 0))
}

  //(c) Is it more convenient to rewrite methods in terms of fold if they were implemented using pattern matching or polymorphism?
  // What does this tell us about the best use of fold?
//answer: more convenient using pattern matching,as only need to do it once, and can
//use anonymous functions to make it even lighter work
  //(d) Why can’t we write our double method in terms of fold? Is it feasible we could
  //if we made some change to fold? answer: because it returns an IntList rather than an Int
  //(e) Implement a generalised version of fold and rewrite double in terms of it.
  //
