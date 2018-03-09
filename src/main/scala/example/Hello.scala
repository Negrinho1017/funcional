package example

import example.Demo.{factorial, fibonacci}

object Hello extends Greeting with App {
  println(greeting)
  println( "Returned Value : " + factorial(10) );
  println( "Returned Value : " + fibonacci(8) );
}

trait Greeting {
  lazy val greeting: String = "hello"
}

object Demo {
  def main(args: Array[String]) {
    println( "Returned Value : " + factorial(10) );
    println( "Returned Value : " + fibonacci(8) );
  }

  def factorial(n: Int): Int = n match{
    case 0 => 1
    case _ => n * factorial(n-1)
  }

  def fibonacci(n: Int): Int = n match{
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n-2) + fibonacci(n-1)
  }
  type Result = Either[String, (Int, Int)]
  def divide(dividend: Int, divisor: Int): Result =
    if (divisor == 0) Left("Division by zero")
    else Right((dividend / divisor, dividend % divisor))
}
trait Sumable[T]{
  def sumar(a: T, b: T): T
  def zero: T
}
case class Person(patrimonio: Double)
object SumableOps2{
  implicit object IntSumable extends Sumable[Int]{
    def sumar(a:Int, b:Int): Int = a+b
    def zero: Int = 0
  }
  implicit object StringSumable extends Sumable[String]{
    def sumar(a:String, b:String): String = a+b
    def zero: String = ""
  }
  implicit object PersonSumable extends Sumable[Person]{
    def sumar(a:Person, b:Person): Person = Person(a.patrimonio+b.patrimonio)
    def zero: Person = Person(0)
  }
}


