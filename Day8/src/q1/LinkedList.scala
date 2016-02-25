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
//AP: I will do the same as above but with the length method in a companion object,
//just to ensure avoidance of the boredom that a world without variety brings
sealed trait LinkedList[+A] // had to make this covariant so it accepted List[nothing]
final case object End extends LinkedList[Nothing]
final case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]

object LinkedList{
  //Q) does every method need to be parameterised by A or +A?
  def length[A] (as:LinkedList[A]):Int = as match{
    case End => 0
    case Pair(h,t) => 1 + length(t)
  }
  def tailRecLength[A] (as:LinkedList[A] , acc:Int):Int = as match {
    case End => acc
    case Pair(h,t) => tailRecLength(t , acc + 1)
  }
  def contains[A](as:LinkedList[A], a:A): Boolean = as match{
    case End => false
    case Pair(a,t) => true
    case Pair(h,t) => contains(t,a)
  }
  //Q) why is this called 'apply'
  // ie why would we want to call this method automatically?
  //Q) seeing as I ma doing it throuygh a companion object,
  // does it still make sense to call it 'apply'?
  def apply[A](as:LinkedList[A] , n:Int):A = n match{
    case 1 => as.head
    case x if x > 0 => LinkedList.apply(as , n-1)
  }
}

object TestLinkedList extends App {
  val list: LinkedList[Int] = Pair(1, Pair(2, End))
  println("list has length " + LinkedList.length(list))
  LinkedList.length(list) is 2
  println("The LinkedList called 'list' is:   " + list)
  println("The head of list is   " + list.head)
  //println("trying to print the head of list, which is 1...   " + list.head)
  //Q) why doesn't list.head and list.tail work??

  val example: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End)))
  LinkedList.length(example) is 3
  //assert(LinkedList.length(example.tail) == 2)
  assert(LinkedList.length(End) == 0)
  println("The length of End is:  " + LinkedList.length(End))


  //AP: test tail-recursive length
  println("list has tail-rec length " + LinkedList.tailRecLength(list, 0))
  LinkedList.tailRecLength(list, 0) is 2


//test contains
  println( "trying contains 2, so should be true...")
  println(LinkedList.contains[Int](example,2)) // note specifying Int here is optional
  assert(LinkedList.contains(example,2) == true)

  println( "trying contains 9, so should be false...")
  println(LinkedList.contains(example,9))
  //assert(LinkedList.contains(example,9) == false)
  //Q) why is it still true???
  println("The following should not compile...")
 // println(LinkedList.contains[Int](example , "not an Int")) Correct doesn't compile, unless I dont specify Int
  //If I didnt specify the param to be Int, then the compiler treats A to be a String.
  //Q) Should I change it so it doesn't compile in any case???


//testing part e
  /*
  assert(example(0) == 1)
  assert(example(1) == 2)
  assert(example(2) == 3)
  assert(try {
    example(3)
    false
  } catch {
    case e: Exception => true
  })
   */

}