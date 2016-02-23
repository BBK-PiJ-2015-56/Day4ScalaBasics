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
item is in the list. Ensure your code works with the following test cases:val example = Pair(1, Pair(2, Pair(3, Empty())))
assert(example.contains(3) == true)
assert(example.contains(4) == false)
assert(Empty().contains(0) == false)
// This should not compile
// example.contains("not an Int")
 */

/*
sealed trait LinkedList[A]{
  def length:Int
}
final case object End extends LinkedList[Nothing]{
  def length = 0
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]{
  def length = {

  }
}
*/

//AP: do the same as above but with the length method in a companion object
sealed trait LinkedList[A]
final case object End extends LinkedList[Nothing]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object LinkedList{
  def length[A] (as:LinkedList[A]) = as match{
    case End => 0
    case Pair[A](h,t) => 1 + length(t)
      //???????????????????????????????
  }
}

//AP: do the same but using tail-recursion

// threaded trees, continuation mutual recursion
 n  n