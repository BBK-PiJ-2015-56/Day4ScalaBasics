//REPL QUESTIONS
val a = 17
//a =20 - didnt allow as val immutable
val b = "ABC1234"
//cannot change
val c = 15.56
print(c)
println(c)
println()
//Expressions
var sky = "sunny"
var temp = 85
//var test = (sky == sunny) && (temp >=80)
1.0 < 0.5
sky == "raining"
sky == "sunny"
(sky == "sunny") && (temp >=80)
sky == "sunny" && temp >=80
var tempC = (temp - 32) * 5.0/9

def isArg1GreaterThanArg2(firstNumber:Double,secondNumber: Double):Boolean = {
  if(firstNumber > secondNumber) {
      true
  } else{
      false
  }
}
var p  = 4.1
var q = 4.12
isArg1GreaterThanArg2(p,q)

val t1 = isArg1GreaterThanArg2(p,q)
assert(!t1)
//assert(t1)



var x=5
type x

def manyTimesString(str:String , num:Int):String = {
  var result = ""
  for (i <- 1 to num)
    result += str
  result
}
val word = "Hello"
val number = 5
manyTimesString(word,number)

val word2 = "Goodbye"
manyTimesString(word2, 10)





