package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }

  "The Demo object" should "say 120" in {
    Demo.factorial(5) shouldEqual 120
  }

  "The Demo object" should "say 13" in {
    Demo.fibonacci(7) shouldEqual 13
  }

  "The Demo divide" should "say error" in {
    Demo.divide(8,0) shouldEqual(Left("Division by zero"))
  }

  "The Demo divide" should "say 2,0" in {
    Demo.divide(8,4) shouldEqual(Right(2,0))
  }

  "The sumable" should "say 300000" in {
    val persona3: Person = Person(180000)
    val persona4: Person = Person(120000)
    SumableOps2.PersonSumable.sumar(persona3,persona4) shouldEqual(Person(300000))
  }
}
