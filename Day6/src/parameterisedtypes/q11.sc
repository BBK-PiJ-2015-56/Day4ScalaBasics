/*
17. Modify the method explicit in the following code:
import atomic.AtomicTest._
// Return type is inferred:
def inferred(c1: Char, c2: Char, c3: Char) = {
Vector(c1, c2, c3)
}
// Explicit return type:
def explicit(c1: Char, c2: Char, c3: Char):
Vector[Char] = {
Vector(c1, c2, c3)
}
inferred('a', 'b', 'c') is "Vector(a, b, c)"
explicit('a', 'b', 'c') is "Vector(a, b, c)"
so it creates and returns a Vector of Double. Satisfy the following tests:
explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)
 */
def explicitDouble(d1: Double, d2: Double, d3: Double):
Vector[Double] = {
  Vector(d1, d2, d3)
}
assert(explicitDouble(1.0, 2.0, 3.0) == Vector(1.0, 2.0, 3.0))

def explicitList(vector:Vector[Double] ): List = {

}





