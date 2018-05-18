package example

sealed trait Vehiculo{
  def placa: String
}

case class Carro(placa: String, cilindraje: Int) extends Vehiculo
case class Moto(placa: String) extends Vehiculo

object Carro{
  def apply(placa: String, cilindraje: Int): Either[String, Carro] = for{
    _ <- if(placa.size != 6) Left("Placa invalida") else Right(placa)
    _ <- if(cilindraje <= 0) Left("CIlindraje invalido") else Right(cilindraje)
  } yield new Carro(placa, cilindraje)
}

object Moto{
  def apply(placa: String): Either[String, Moto] = {
    if(placa.size != 6) Left("Placa invalida") else Right(new Moto(placa))
  }
}
