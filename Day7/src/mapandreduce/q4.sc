//q4

val list = List( 1 ,2 ,3 )

val sum1 = List(2, 3, 4).reduceLeft(_ + _)
println(sum1)
def sumIt(list:List[Int]):Int = {
  list.reduceLeft(_ + _)
}
val sum = sumIt(list)
assert(sumIt(List(45, 45, 45, 60))== 195)

//The following is better as it also constructs the List,
//so passes the test that Keith set
def sumItNoList(in: Int*):Int = {
  val list = in.toList
  list.reduceLeft(_ + _)
}
assert(sumItNoList(45, 45, 45, 60)== 195)


//The following does it in one line

def sumItOneLine(in:Int*) = in.toList.reduceLeft(_ + _)
println("Here is result for sumItOneLine:" + sumItOneLine(45,45,45,60))

//Here is a different way using a and b

def sumItUsingAB(in:Int*) = in.toList.reduceLeft((a,b) => a + b)
println("Here is result for sumItUsingAB: " + sumItUsingAB(45,45,45,60))

//The following uses reduce instead of reduceLeft,as Left is irrelevant
//because a + b = b + a  for all a , b <- Z
def sumItWithReduce(in:Int*) = in.toList.reduce(_ + _ )
println("Here is result for sumItWithReduce: " + sumItUsingAB(45,45,45,60))
