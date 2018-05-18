package example


class IngresarVehiculo(vehiculo: Vehiculo) {
  def execute: VehiculoIngresado = VehiculoIngresado(vehiculo,System.currentTimeMillis())
}

