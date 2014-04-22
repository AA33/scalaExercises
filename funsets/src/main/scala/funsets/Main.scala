package funsets

object Main extends App {
  import FunSets._

  printSet(getBigSet(10))
  printSet(map(getBigSet(10),(x: Int) => x*x*x))
}
