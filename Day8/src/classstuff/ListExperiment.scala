package classstuff

/**
 * Created by pdomok01 on 25/02/2016.
 */
object ListExperiment extends App{

  val ints = List(1,2,3,4)
  val apple = Apple
  val orange = Orange
  val fruits = List(apple , orange)
  val list: List[Any] = ints :: fruits
  println(list)

  val list2:List[Any] = ints :: List(apple)
  println(list2)

  val list3 = ints :: List(5)
  println(list3)

  val list4 = ints :+ 10
  println(list4)
  val list5 = ints :+ apple
  println(list5)
  //val list6: List[Any] = ints +: apple
  //println(list6)

  val list8:List[Any] = List( 1, 2 , "Hello")

}
trait Fruit
case class Apple() extends Fruit
case class Orange() extends Fruit
