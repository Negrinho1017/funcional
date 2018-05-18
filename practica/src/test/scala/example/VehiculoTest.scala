package example

import org.scalatest._

class VehiculoTest extends FlatSpec with Matchers {
  "The Vehiculo object" should "bring me a vehiculo object" in {
    val validation: Either[String, Carro] = Carro("KAS353", 1400)
    validation.fold(_ => succeed,
      c => {
        c.cilindraje should be(1400)
        c.placa should be("KAS353")
      }
    )
  }

  "The Vehiculo object" should "bring me a moto object" in {
    val validation: Either[String, Moto] = Moto("KAS353")
    validation.fold(_ => succeed,
      c => {
        c.placa should be("KAS353")
      }
    )
  }

  "The Vehiculo object" should "bring me an error in the placa attribute" in {
    val validation: Either[String, Carro] = Carro("KAS33", 1400)
    validation.fold(s => "Placa invalida",_ => fail)
  }

  "The Vehiculo object" should "bring me an error in the cilindraje attribute" in {
    val validation: Either[String, Carro] = Carro("KAS353", -1400)
    validation.fold(s => "Cilindraje invalido",_ => fail)
  }

  "The Vehiculo object" should "bring me an error in the placa attribute moto" in {
    val validation: Either[String, Moto] = Moto("KAS33")
    validation.fold(s => "Placa invalida",_ => fail)
  }
}
