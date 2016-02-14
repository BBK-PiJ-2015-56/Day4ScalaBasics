import java.io.FileWriter

import scala.language.implicitConversions

/* I have had to cut and paste due to teh following errors:

Error:object atomicscala is not a member of package com
import com.atomicscala.AtomicTest._
           ^
 */


class AtomicTest[T](val target: T) {
  val errorLog = "_AtomicTestErrors.txt"

  def tst[E](expected: E)(test: => Boolean) {
    println(target)
    if (test == false) {
      val msg = "[Error] expected:\n" +
        expected
      println(msg)
      val el = new FileWriter(errorLog, true)
      el.write(target + msg + "\n")
      el.close()
    }
  }

  def str = // Safely convert to a String
    Option(target).getOrElse("").toString

  def is(expected: String) = tst(expected) {
    expected.replaceAll("\r\n", "\n") == str
  }

  def is[E](expected: E) = tst(expected) {
    expected == target
  }

  def beginsWith(exp: String) = tst(exp) {
    str.startsWith(
      exp.replaceAll("\r\n", "\n"))
  }
}

object AtomicTest {
  implicit def any2Atomic[T](target: T) =
    new AtomicTest(target)
}

import AtomicTest._

//q1

def forecast(percent: Int): String = {
  percent match{
    case 100 => "sunny"
    case  80 => "mostly sunny"
    case  50 => "partly sunny"
    case  20 => "mostly cloudy"
    case   0 => "cloudy"
    case   _ => "unknown"
  }

}
/*
object MyForecastTest extends App {
  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20) is "Mostly Sunny"
  forecast(0) is "Cloudy"
  forecast(15) is "Unknown"
  def forecast(temp: Int): String = ???
}*/

// Q) how do we run test?

assert(forecast(100) == "sunny")
assert(forecast(15) == "unknown")


//q2
val vector = Vector(100,80,50,20,0,15)
println(vector(0))
println(forecast(vector(0)))

//Q)  index outofbounds error   ????
//for(i <- vector) println("forecast is " + forecast(vector(i)))

// using 'to' prints all of them up to and including the 5th element
for(i <- 1 to 5) println(forecast(vector(i)))

//using 'until' prints all of them not including the 5th element
for(i <- 1 until 5) println(forecast(vector(i)))














