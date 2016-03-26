

import scala.io.StdIn.readLine

class GuessImpl(rowSize: Int) extends Guess {
  val guess = requestGuess()
  
  def requestGuess(): Seq[Peg] = {
    print("\nEnter a guess:   ")
    val input = readLine()
    val parser: GuessParser = new GuessParserImpl(input, rowSize) //dependency
    if (parser.isValid()) {
      parser.parse()
    } else {
      println("Invalid input. Try again.")
      requestGuess()
    }
  }
  
  override def toString(): String = {
    var result = ""
    for (peg <- guess)
      result += peg
    result
  }
}