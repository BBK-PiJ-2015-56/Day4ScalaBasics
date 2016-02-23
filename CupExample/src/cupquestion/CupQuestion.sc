
/* I have had to cut and paste due to teh following errors:

Error:object atomicscala is not a member of package com
import com.atomicscala.AtomicTest._

incorrect package name (when I tried to name my package patternmatching)
           ^
 */


//import AtomicTest._
//qs why do we need to import when its in same file ie same package?
/*
import atomicscala.AtomicTest._

class Cup {
  var percentFull = 0
  val max = 100
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }
}

val cup = new Cup

cup.add(45) is 45
cup.add(-15) is 30
cup.add(-50) is -20
*/