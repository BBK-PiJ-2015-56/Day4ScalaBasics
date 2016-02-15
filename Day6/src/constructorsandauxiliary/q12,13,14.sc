/*
12. Create a class called ClothesWasher with a default constructor and two auxiliary constructors,
one that specifies modelName (as a String) and one that specifies capacity
(as a Double).
13. Create a class ClothesWasher2 that looks just like your solution above,
but use named and default arguments instead so that you can produce
the same results with just a default constructor.
14. Show that the first line of an auxiliary constructor must be a call to the primary constructor.

 */

//q12
class ClothesWasher(val name:String , val capacity:Double){

  def this(name:String) = this(name , 0)
  //what should I use? option[nothing] / none? How do I do it without using 0?
  def this(capacity:Double) = this("" , capacity)
}
val cw = new ClothesWasher("FreshClo" , 10)
val cw2 = new ClothesWasher("Sparkle")
val cw3 = new ClothesWasher(20)
println(cw.name , cw.capacity)
println(cw2.name , cw2.capacity)
println(cw3.name , cw3.capacity)

