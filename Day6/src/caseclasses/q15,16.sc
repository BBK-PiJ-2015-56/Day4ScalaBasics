/*

15. Create a case class to represent a Person in an address book,
complete with Strings for the name and a String for contact information.
Satisfy the following tests:
val p = Person("Jane", "Smile", "jane@smile.com")
p.first is "Jane"
p.last is "Smile"
p.email is "jane@smile.com"

16. Create some Person objects. Put the Person objects in a Vector.
Satisfy the following tests:

val people = Vector(
  Person("Jane","Smile","jane@smile.com"),
  Person("Ron","House","ron@house.com"),
  Person("Sally","Dove","sally@dove.com"))
people(0) is "Person(Jane,Smile,jane@smile.com)"
people(1) is "Person(Ron,House,ron@house.com)"
people(2) is "Person(Sally,Dove,sally@dove.com)"
*/
//Note: no need to declare var or val in params for case class - it instantiates them anyway
//Note2: don't need the 'new' keyword either for case classes, as it uses apply method to instantiate
case class Person(name:String , info:String)
val p = Person("peter" , "footballer")
println(p)
assert(p.name =="peter")

val p2 = Person("john" , "actor")
print("name is " + p2.name)

val p3 = Person( "Mario" , "singer")

val people = Vector(p , p2 , p3)
println(people(0))
println(people)



