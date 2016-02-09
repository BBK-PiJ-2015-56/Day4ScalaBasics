//Classes Questions

class Hippo()
val hippo = new Hippo()
println(hippo)

class Lion(){}
val lion = new Lion()
println(lion)

val lion2 = new Lion()
println(lion2)

val lion3 = new Lion()

//Methods inside classes questions

//q1

//class Sailboat(sailStatus:String){
  //var sail: String = sailStatus
// Q) As a functional language, is it ok for
// methods to have such side effects as changing fields which are not passed
//in as args?

class Sailboat(){

  def raiseSail(): String ={
    "sail raised"
  }
  def lowerSail(): String ={
    "sail lowered"
  }

}

class MotorBoat(){
  def startMotor(): String ={
    "motor on"
  }
  def stopMotor():String ={
    "motor off"
  }
}

val sailboat = new Sailboat
val r1 = sailboat.raiseSail()
assert(r1 == "sail raised", "Expected sail raised, Got " + r1)

//test for failure
//assert(r1 == "pie", "Expected pie, got " +r1)











