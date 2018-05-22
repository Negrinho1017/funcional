package sumable

class Operaciones {
  def sum[T](a:T, b:T)(implicit s:Sumable[T]): T = s.sumar(a,b)
}
