/*
20. Working from your solution to the exercise above, add a comma between each number.
    Satisfy the following test:
    str is "1,2,3,4,"
*/

//q19 repeated

def explicitSet(vector:Vector[Double] ): Set[Double] = {
  vector.toSet[Double]
}
val vector1 = Vector[Double](1, 2, 3)
explicitSet(vector1)

//q20
//Q) When shd we use def and when shd we use val/var? what is the difference>
//Q) why is the + underlined here?
//Q) Is there a way I could write this in it's function form?
val str = {
  var temp = ""
  for (i <- (explicitSet(vector1)))
    temp += i + ", "
  temp
}
println(str)
 def str2 = {
  var temp = ""
  for (i <- (explicitSet(vector1)))
    temp.+= (i + ", ")
  temp
}
println(str)

//Function format f:Set[Double] -> String    ?????