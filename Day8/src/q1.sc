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


sealed trait IntList
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList