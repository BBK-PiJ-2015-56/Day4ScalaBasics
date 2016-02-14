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


class TradFamily(mum:String , dad:String , children:String*){
  def familySize():Int = children.size + 2
  val childrenList = children
  // not sure why we have to do this, and how do we make it called children
}
val tradFam = new TradFamily("Mum" , "Dad" , "Katie" , "Gemma" , "Ben")
println("The size of tradFam is " + tradFam.familySize())
//println("There is " + tradFam.mum + ", " + tradFam.dad + "and "
// + tradFam.children.size + " children.")
// not sure why you can access the fields when you explicitly declare
// them in the constructor body,
// but not when you leave it to the compiler to create teh fields from
// the parameters given.
println("There are "+ tradFam.childrenList.size + " children.")
println("There names are " + tradFam.childrenList.toString())

//q5 not done but easy




