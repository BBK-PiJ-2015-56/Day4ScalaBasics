package q1
import atomicscala.AtomicTest._

/**
  * Created by peted on 23/02/2016.
  */
/* Q 1a-d
1. Given the following type:
sealed trait IntList
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
(a) Change the name to LinkedList and make the type of data stored in the list
generic.
(b) Now implement length, returning the length of the LinkedList. Some test
cases are below:
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)
(c) Now implement a method contains that determines whether or not a given
item is in the list. Ensure your code works with the following test cases:
val example = Pair(1, Pair(2, Pair(3, Empty())))
assert(example.contains(3) == true)
assert(example.contains(4) == false)
assert(Empty().contains(0) == false)
// This should not compile
// example.contains("not an Int")
 */
/*
sealed trait LinkedList[A]{ def length:Int}
final case object End extends LinkedList[Nothing]{def length = 0}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]{ def length = {}
}
*/
//AP: do the same as above but with the length method in a companion object
sealed trait LinkedList[+A] // had to make this covariant so it accepted List[nothing]
final case object End extends LinkedList[Nothing]
final case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]

object LinkedList{
  def length[A] (as:LinkedList[A]):Int = as match{
    case End => 0
    case Pair(h,t) => 1 + length(t)
  }
  //def tailRecLength[A] (as:LinkedList[A] , acc:Int):Int = {
  //  case End => acc
   // case Pair(h,t) => tailRecLength(t , acc + 1)
  //}
  def contains[A](as:LinkedList[A] , a:A): Boolean = {
    case End => false
    case Pair(a,t) => true
    case (h,t) => contains(t,a)
  }
}

object TestLinkedList extends App {
  val list: LinkedList[Int] = Pair(1, Pair(2, End))
  println("list has length " + LinkedList.length(list))
  LinkedList.length(list) is 2
  println(list)
  //println(list.head)
  //Q) why doesn't list.head and list.tail work??

  val example: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End)))
  LinkedList.length(example) is 3
  //assert(LinkedList.length(example.tail) == 2)
  assert(LinkedList.length(End) == 0)
  println(LinkedList.length(End))
}

  //AP: test tail-recursive length
  //println("list has length " + LinkedList.tailRecLength(list, 0))
  //LinkedList.tailRecLength(list,0) is 2
  // println(list)
  /* Q) runtime Error:(44, 59) missing parameter type for expanded function
  The argument types of an anonymous function must be fully known. (SLS 8.5)
  Expected type was: Int
  def tailRecLength[A] (as:LinkedList[A] , acc:Int):Int = {
  ^*/


  //assert(example.contains(3) == true)
  //assert(example.contains(4) == false)
  //assert(Empty().contains(0) == false)
  // This should not compile
  // example.contains("not an Int")
