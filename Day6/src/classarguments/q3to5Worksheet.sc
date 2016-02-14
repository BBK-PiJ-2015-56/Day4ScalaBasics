//q3
class Family(name:String){
  val person = name
}

val fam = new Family("Mum")

println(fam.person)
class LargeFamily(names: String*){
  val listOfNames = names

  def familySize():Int = listOfNames.size
}
val largeFam = new LargeFamily("Mum" , "Dad" , "Sally" , "Dick")
println(largeFam.listOfNames)
println(largeFam.familySize)
//Q) why didn't this work:
//   type largeFam.listOfNames
//   AP -> need to learn about WrappedArrays,
//   and seq and cllections generally

//Note: We don't need to declare the val listOfNames?
// It does this automatically.see next example
//q4

class LargeFam2(names:String*){
  def familySize():Int = names.size
}
val largeFam2 = new LargeFam2("Mum" , "Dad", "Joe" , "Callum")
println("This fam is of size: " + largeFam2.familySize())


class TradFamily(val mum:String , val dad:String , val children:String*){
  def familySize():Int = children.size + 2
}
val tradFam = new TradFamily("Mum" , "Dad" , "Katie" , "Gemma" , "Ben")
println("The size of tradFam is " + tradFam.familySize())
//println("There is " + tradFam.mum + ", " + tradFam.dad + "and "
// + tradFam.children.size + " children.")
// not sure why you can access the fields when you explicitly declare
// them in the constructor body,
// but not when you leave it to the compiler to create teh fields from
// the parameters given.
//ANSWER: need  to declare var or val before the name in the param list
// in class declaration
println("There are "+ tradFam.children.size + " children.")
println("There names are " + tradFam.children.toString())

//q5 not done but easy




