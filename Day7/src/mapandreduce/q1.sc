//q1
/*
1. (a) Modify the following code:
import atomic.AtomicTest._
val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)
so the anonymous function multiplies each value by 11 and adds 10.
Satisfy the following tests:
val v = Vector(1, 2, 3, 4)
v.map(/* Fill this in */) is Vector(21, 32, 43, 54)
(b) Can you replace map with foreach in the above solution? What happens?
 Test the result.
(c) Rewrite the solution for the previous exercise part using for.
 Was this more or less complex than using map?
 Which approach has the greater potential for errors?
 */
//q1a)
val v = Vector(1, 2, 3, 4)
assert(v.map(n => n *11 + 10) == Vector(1*11+10,32 ,43, 54))

//note: you can put expressions in the vector like above for 1 too

//q1b)
val v2 = Vector(1,2,3,4)
val v3 = v2.foreach(i => i*11+10)
println(v3)
type v3

//need to sort this out so it's a vector




