package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("Count change:" + countChange(6, List(3, 2)))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(chars: List[Char], opens: Int, closes: Int): Boolean = {
      if (chars.isEmpty) {
        if (opens == 0 && closes == 0) {
          true
        } else {
          false
        }
      } else if (chars.head.toString() == "(" && opens >= closes) {
        checkBalance(chars.tail, opens + 1, closes)
      } else if (chars.head.toString() == ")" && opens >= closes) {
        checkBalance(chars.tail, opens - 1, closes)
      } else {
        checkBalance(chars.tail, opens, closes)
      }
    }
    checkBalance(chars, 0, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      println()
      1
    } else if (coins.isEmpty) {
      println()
      0
    } else {
      if (money - coins.head >= 0) {
        print(coins.head + " ")
        countChange(money - coins.head, coins) + countChange(money - coins.head, coins.tail)
      } else
        countChange(money, coins.tail)
    }
  }

}
