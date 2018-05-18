package example

import org.scalatest.{FlatSpec, Matchers}

class RetirarVehiculoTest extends FlatSpec with Matchers {
  "The Carro object" should "bring me a prize of 0" in {
    val carro: Carro = Carro("KAS353", 1400).right.get
    val vehiculoIngresado = VehiculoIngresado(carro, System.currentTimeMillis())
    val vehiculoRetirado = new RetirarVehiculo(vehiculoIngresado)
    vehiculoRetirado.calcularPrecioPorCilindraje(carro) should be(0)
  }

  "The Carro object" should "bring me a prize of 2000" in {
    val carro: Carro = Carro("KAS353", 1400).right.get
    val vehiculoIngresado = VehiculoIngresado(carro, System.currentTimeMillis())
    val vehiculoRetirado = new RetirarVehiculo(vehiculoIngresado)
    vehiculoRetirado.calcularPrecio(vehiculoIngresado) should be(2000)
  }

  "The Moto object" should "bring me a prize of 2000" in {
    val moto: Moto = Moto("KAS353").right.get
    val vehiculoIngresado = VehiculoIngresado(moto, System.currentTimeMillis())
    val vehiculoRetirado = new RetirarVehiculo(vehiculoIngresado)
    vehiculoRetirado.calcularPrecio(vehiculoIngresado) should be(1000)
  }
}
