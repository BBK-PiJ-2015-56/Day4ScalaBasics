/*Create a class Planet that has, by default, a single moon. The Planet class should
have a name (String) and description (String). Use named arguments to specify the
  name and description, and a default for the number of moons. Satisfy the following
tests:
val p = new Planet(name = "Mercury",
  description = "small and hot planet", moons = 0)
p.hasMoon is false
*/

class Planet (name:String , desc:String , moons:Int = 1){
  def hasMoon():Boolean = {
    if (moons == 0) false
    else true
  }
}

val p = new Planet(name = "Mercury" , desc = "small and hot planet", moons = 0)
assert(p.hasMoon() == false)


//q9 not done but easy