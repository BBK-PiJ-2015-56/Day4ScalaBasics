//q11

/*11. Create a new class Tea that has two methods:
  describe — which includes information about whether the tea includes milk, sugar,
is deca einated, and includes the name; and
calories — which adds 100 calories for milk and 16 calories for sugar.
  Satisfy the following tests:


package tea
import atomic.AtomicTest._
object TeaScript extends App {
  val tea = new Tea
  tea.describe is "Earl Grey"
  tea.calories is 0
  val lemonZinger = new Tea(decaf = true, name="Lemon Zinger")
  lemonZinger.describe is "Lemon Zinger decaf"
  lemonZinger.calories is 0
  val sweetGreen = new Tea( name="Jasmine Green", sugar=true)
  sweetGreen.describe is "Jasmine Green + sugar"
  sweetGreen.calories is 16
  val teaLatte = new Tea(sugar=true, milk=true)
  teaLatte.describe is "Earl Grey + milk + sugar"
  teaLatte.calories is 116
}
*/

//Q) Is the way I'm doing this the best for scala?
//Q) also is my approach good in terms of TDD?
class Tea(name:String = "Earl Grey" , sugar:Boolean = false , milk:Boolean = false , decaf:Boolean = false){
  def describe():String = {
    var info = name
    if (milk)
      info += " + milk"
    if(sugar)
      info += " + sugar"
    info
  }
  def calories():Int = {
    var calCount = 0
    if(sugar)
      calCount+= 16
    if(milk)
      calCount+=100
    calCount
  }
}
val tea = new Tea
assert(tea.describe == "Earl Grey")
assert(tea.calories == 0)
val lemonZinger = new Tea(decaf =true , name = "Lemon Zinger")
assert(lemonZinger.describe == "Lemon Zinger")
assert(lemonZinger.calories == 0)
val sweetGreen = new Tea(name="Jasmine Green" , sugar = true)
assert(sweetGreen.describe == "Jasmine Green + sugar")
assert(sweetGreen.calories == 16)
val teaLatte = new Tea(sugar = true , milk = true)
assert(teaLatte.describe == "Earl Grey + milk + sugar")
assert(teaLatte.calories == 116)

