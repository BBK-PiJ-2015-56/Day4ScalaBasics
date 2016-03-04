package q10int

/**
 * Created by pdomok01 on 04/03/2016.
 */
//10. Write an implementation Integer of integer numbers. The implementation should
//support all operations of class Nat:

// it doesn't feel right ot make Integer a subtype of Nat, because nat is a subset of integer, inn the same way that dog is a subest of animal.
// //But then again, integer is teh type that has teh added functionality eg predecessor method, so in that sense integer is like dog.
//Q) how would we do this without subtypes and polymorphism?
// it is the

/*
trait Nat
class Succ extends Nat
class Zero extends Nat
trait Integer extends Nat
class
*/

// Note I am implementing it by generalising the trait for educational purposes,
// but the more intuitive way is to create a trait Integer that has a Nat and a sign(pos or neg)
  trait Integer {
  def isZero: Boolean
  def predecessor: Integer
  def successor: Integer
  def +(that: Integer): Integer
  def -(that: Integer): Integer
  }

  class Succ(x: Integer) extends Integer {
    override def isZero: Boolean = false
    override def predecessor: Integer = x
    override def successor: Integer = new Succ(this)
    override def +(that: Integer): Integer = x + that.successor
    override def -(that: Integer): Integer = if (that.isZero) this
    else x - that.predecessor
  }

  class Pred(x: Integer) extends Integer {
    override def isZero: Boolean = false
    override def successor: Integer = x
    override def predecessor: Integer = new Pred(this)
    override def +(that: Integer): Integer = x + that.successor
    override def -(that: Integer): Integer = if (that.isZero) this
    else x - that.predecessor
  }
object Zero extends Integer {
  override def isZero: Boolean = true
  override def predecessor: Integer = sys.error("negative number")
  override def successor: Integer = new Succ(Zero)
  override def +(that: Integer): Integer = that
  override def -(that: Integer): Integer = if (that.isZero) Zero
  else sys.error("negative number")
}

  object IntegerTest extends App{
    // going to create 2 and 3, and then do 2 + 3 and 3-2
    val one = new Succ(Zero)
    val two = one.successor
    val three = two.successor
    val four = three.successor
    val five = four.successor
    val p = three - two
    println(p)
    assert(p == one)
    val q = two + three
    //assert (q == five) failed!
    val r = two + Zero
    //assert(r == two) failed!
  }

/*
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}
class Succ(x: Nat) extends Nat {
  override def isZero: Boolean = false
  override def predecessor: Nat = x
  override def successor: Nat = new Succ(this)
  override def +(that: Nat): Nat = x + that.successor
  override def -(that: Nat): Nat = if (that.isZero) this
  else x - that.predecessor
}
object Zero extends Nat {
  override def isZero: Boolean = true
  override def predecessor: Nat = sys.error("negative number")
  override def successor: Nat = new Succ(Zero)
  override def +(that: Nat): Nat = that
  override def -(that: Nat): Nat = if (that.isZero) Zero
  else sys.error("negative number")
}
 */