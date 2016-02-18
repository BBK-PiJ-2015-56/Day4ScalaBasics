//package traitsandinheritance
//Q) what should I put so I can call it a package name
//- should I wrap everythig inside an object?
/*
5. (a) Define a trait called Shape and give it three abstract methods:
 i. sides returns the number of sides;
ii. perimeter returns the total length of the sides;
iii. area returns the area.
Implement Shape with three classes: Circle, Rectangle, and Square.
In each case provide implementations of each of the three methods.
Ensure that the main constructor parameters of each shape
(e.g., the radius of the circle) are accessible as fields.
  Tip: The value of π is accessible as math.Pi.
  */
trait Shape{
  def sides: Int
  def perimeter: Double
  def area: Double
}
//Q) does case class automatically create getters for
//constructor params? also, is radius a val or a var here?
// answer: its a val by default, unless declared as a var,
// as I have below simply for demo purposes(bad idea in practice)
case class Circle(var radius :Double) extends Shape{
  def sides = 1
  def perimeter = radius * 2 * Math.PI
  def area = Math.PI * Math.pow(radius,2)
  def setRadius(in:Double) = {
    radius = in
  }
}
case class Rectangle(length :Double , width :Double) extends Shape{
  def sides = 4
  def perimeter = 2*(length + width)
  def area = length * width
}

//Q) How could I make square extend rectangle using a
// default value for width = length? ans) see part 2.
case class Square (length:Int) extends Shape{
  def sides = 4
  def perimeter = 4*length
  def area = Math.pow(length ,2 )
}

//test params accessible
val circle = Circle(4)
println("perimeter of circle is " + circle.perimeter)
assert(circle.radius == 4)

//check I can reassign radius (bad idea generally but this is a demo)
circle.setRadius(10)
println("radius has changed to " + circle.radius)

/*
(b) The solution from part a delivered three distinct types of shape.
 However, it doesn’t model the relationships between the three correctly.
 A Square isn’t just a Shape –– it’s also a type of Rectangle
 where the width and height are the same.
    We want to avoid case-class-to-case-class inheritance,
    so refactor the solution to the last exercise so that
    Square and Rectangle are subtypes of a common type Rectangular.
*/
//Q) which should be the case class?I'd argue it should be lower down
//the tree, as they are teh ones that will actually be implemented.
//In fact, Rectangular may be abstract.
//Q) How do case classes effect inheritance then.
//I mean, the open for extension principle is at risk
//if we cannot extend a case class with another case class.

class Rectangular extends Shape{
  def sides = ???
  def perimeter = ???
  def area = ???
}

case class Square2(length:Double) extends Rectangular{

}
case class Rectangle2(length:Double , width:Double){

}


/*
(c) i. Make Shape a sealed trait.
ii. Then write a singleton object called Draw
with an apply method that takes a Shape as an argument
and returns a description of it on the console.
For example:
  Draw(Circle(10)) // returns "A circle of radius 10cm"
Draw(Rectangle(3, 4))
// returns "A rectangle of width 3cm and height 4cm"
// and so on...

*/