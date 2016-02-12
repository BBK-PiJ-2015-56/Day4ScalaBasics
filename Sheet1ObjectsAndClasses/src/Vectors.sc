//Vectors
//q1 and 2
println("Hello")

val vector = scala.collection.immutable.Vector.empty
val vector2 =  vector:+5
println(vector)
println(vector2)
val vector3 = 16+: vector2 :+ 26
val list = List( 5 , 6 ,7)
val vector4 = Vector(19 , 22 , 25 , 56)
val vector5 = Vector
println(vector5)
val vector6 = vector3 ++ vector2
val vector7 = vector6 ++ vector4
println(vector7)
val vector8 = vector7.filter(_ != 16)
var vector9 = Vector(1)
val fives = vector7.count(_ == 5)
def isOdd(x:Int ) = {
  (x % 2) == 1
}
val odds = vector7.count(isOdd(_) == true)
val wordVector = Vector("Harry" , "Barry" , "Sally")
val booleanVector = Vector( true , false , true , true , false)
val vectorVector = Vector( wordVector , booleanVector , vector7)
println(vectorVector)
for (i <- wordVector) println (i)
val dogVector = Vector("The" , "dog" , "visited" , "the" , "fire")
val fullDogVector = dogVector :+ "station"
var sentence = ""
for (i <- fullDogVector) if (i != "station") {
  sentence += i
  sentence += " "
}
sentence += "station."
println(sentence)

//note: I wouldn't normally get teh sentence last word and full stop like this.
// I would do it using teh equivalent of itemAt(i) where i is teh index.
// The toString approach is below: ( I want to say foreach string in the Vector, append it with " ")

//fullDogVector.foreach() ????


