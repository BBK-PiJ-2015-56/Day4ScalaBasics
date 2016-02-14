/*
Demonstrate that named and default arguments can be used with methods. Create
a class Item that takes two class arguments: A String for name and a Double for
price.
Add a method cost which has named arguments for grocery (Boolean),
medication (Boolean), and taxRate(Double). Default grocery and medication
to false, taxRate to 0.10.
In this scenario, groceries and medications are not taxable. Return the total cost of
the item by calculating the appropriate tax. Satisfy the following tests:
val flour = new Item(name="flour", 4)
flour.cost(grocery=true) is 4
val sunscreen = new Item(
name="sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name="television", 500)
tv.cost(rate = 0.06) is 530
 */

//Q How can the Boolean exp be simplified more below?
class Item(name:String , price:Double){
  def cost(grocery:Boolean=false , medication:Boolean=false, taxRate:Double=0.10): Double ={
    if(grocery == true || medication == true) price
    else price * (1 + taxRate)
  }
}
val flour = new Item(name="flour" , 4)
assert(flour.cost(grocery=true) == 4.0)

val sunscreen = new Item(name="sunscreen", 3)
assert(sunscreen.cost() > 3.24 && sunscreen.cost() < 3.35)
// Q: Need to work out how to do assert with a given tolerance range

