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

//Q)!!! why is sides a def not a val?
sealed trait Shape{
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
//Q)!!! which should be the case class?I'd argue it should be lower down
//the tree, as they are teh ones that will actually be implemented.
//In fact, Rectangular may be abstract.
//Q) How do case classes effect inheritance then.
//I mean, the open for extension principle is at risk
//if we cannot extend a case class with another case class.
//Q) better to make a square have a length and a width? that way,
// no need to alter the methods. what if you put in a length and a width to the constructor,
// and if they are equal, it constructs a square.
// Then you need it to construct a square, so you would always want to
// call it as a new Rectangular just in case
abstract class Rectangular extends Shape{
  def sides = 4
  //dont need to implement all the methods as it is an abstract class
}
case class Square2(length:Double) extends Rectangular{
  override def perimeter = 4 * length
  override def area = Math.pow(length , 2)
}
case class Rectangle2(length:Double , width:Double) extends Rectangular{
  override def perimeter = 2 * (length + width)
  override def area = length * width
}
val s = Square2(5)
val r = Rectangle2(3,4)
println("Hello")
println("The length of square2 s is " + s.length)
println("The width of rectangle2 r is " + r.width)
println("The area of s is " + s.area)

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

//note: we have made Shape a sealed trait so we can see all teh types of Shape and make sure
//they are all accounted for within Draw.
object Draw{
  def apply(shape:Shape): String = shape match {
    case c:Circle => "A circle of radius " + c.radius
    case s:Square => "A square of length" + s.length
    case r:Rectangle => "A rectangle of length "+ r.length + " and width " + r.width
  }
}
println(Draw(Circle(10)))
Draw(Rectangle(3,4))

//q1d
/*
(d) Write a sealed trait Colour to make our shapes more interesting.
i. give Colour three properties for its RGB values;
ii. create three predefined colours: Red, Yellow, and Pink;
iii. provide a means for people to produce their own custom Colours with their
own RGB values;
iv. provide a means for people to tell whether any Colour is “light” or “dark”.
Note: A lot of this is left deliberately open to interpretation. The important
thing is to practice working with traits, classes, and objects. Decisions such as
how to model colours and what is considered a light or dark colour can either
be left up to you or discussed with other class members.
 */
sealed trait Colour {
  //RGB values go up to 255 - should it be def or val??
  def rValue: Int
  def gValue: Int
  def bValue: Int
}
object Red extends Colour{
}
object Yellow extends Colour
object Pink extends Colour

class MyColour()


//q1e
/*
(e) Edit the code for Shape and its subtypes to add a colour to each shape.
Finally, update the code for Draw.apply to print the colour of the argument as
well as its shape and dimensions (hint: you may want to deal with the colour in
a helper method):
i. if the argument is a predefined colour, print that colour by name:
ii. if the argument is a custom colour rather than a predefined one, print the
word “light” or “dark” instead.
 */
















