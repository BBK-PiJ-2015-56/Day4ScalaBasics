sealed trait LinkedList1[+A] // had to make this covariant so it accepted List[nothing]
final case object End1 extends LinkedList1[Nothing]
final case class Pair1[A](val head: A, val tail: LinkedList1[A]) extends LinkedList1[A]
val list1: LinkedList1[Int] = Pair1(1, Pair1(2, End1))
println(list1)
//println("The head of list1 is: " + list1.head)

val list2:Pair1[Int] = Pair1(1, Pair1(2, Pair1(3 , End1)))
println(list2)
println("The head of list2 is: " + list2.head)


// So if you declare it as a LinkedList then it cannot see Pair, because it doesn't know about it.
// You need to cast it to Pair

//Needless to say, runtime errors are undesirable,
// so the extent to which you can specify things in a type-safe manner
// (without using asInstanceof), the better!
// If you find yourself using asInstanceOf,
// you should probably be using match instead.

//Q) How would I cast using match? What is the best way to cast?