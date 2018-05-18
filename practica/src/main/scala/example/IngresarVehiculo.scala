package example


class IngresarVehiculo(vehiculo: Vehiculo) {
  def execute: VehiculoIngresado = VehiculoIngresado(vehiculo,System.currentTimeMillis())
}

class RetirarVehiculo(vehiculoIngresado: VehiculoIngresado) {
  def execute: Either[String, VehiculoRetirado] = for {
    h <- Right(calcularTiempo(vehiculoIngresado.horaEntrada))
    p <- Right(calcularPrecio(vehiculoIngresado))
    i <- Right(calcularPrecioPorCilindraje(vehiculoIngresado.vehiculo))
  } yield new VehiculoRetirado(vehiculoIngresado.vehiculo, h*p + i)
  def calcularPrecioPorCilindraje(vehiculo: Vehiculo): Int = vehiculo match{
    case Carro(_,c) if (c > 2000) => 2000
    case _ => 0
  }
  def calcularPrecio(vehiculoIngresado: VehiculoIngresado): Int = vehiculoIngresado.vehiculo match{
    case Carro(_,_) => 2000
    case Moto(_) => 1000
  }
  def calcularTiempo(horaEntrada: Long): Int ={
    ((System.currentTimeMillis() - horaEntrada)/3600000).toInt
  }
}

