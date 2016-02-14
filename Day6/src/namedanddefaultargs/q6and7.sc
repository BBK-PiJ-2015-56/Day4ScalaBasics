// q6 Named arg
class SimpleTime(val hours:Int , val mins:Int){

}

val t = new SimpleTime(mins = 30 , hours = 5)
assert(t.hours == 5)

//q7 Default arg
class SimpleTimeDefaultMins(val hours:Int , val mins:Int = 0)
val t2 = new SimpleTimeDefaultMins(5)
//note that it will assume the 5 belngs to the variable that has no default.
//could also have named arg hours=5 to avoid confusion
assert(t2.hours == 5)
assert(t2.mins == 0)
println(t2.hours)
println(t2.mins)

//

