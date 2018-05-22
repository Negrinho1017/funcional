package example

trait Sumable[T]{
def sumar(a: T, b: T): T
def zero: T
}

object SumableOps{
  implicit object IntSumable extends Sumable[Int]{
    def sumar(a:Int, b:Int): Int = a+b
    def zero: Int = 0
  }
  implicit object StringSumable extends Sumable[String]{
    def sumar(a:String, b:String): String = a+b
    def zero: String = ""
  }
}
