package coursework

import com.google.inject.Inject;
import scala.io.StdIn.readLine

/**
 * Implements the trait Guess.
 * 
 * @param parser a parser object to validate user input and turn user input in a sequence of pegs.
 */
class GuessImpl @Inject() (parser: GuessParser) extends Guess {
  
  def requestGuess(rowSize: Int): Seq[Peg] = {
    print("What is your next guess?\n" +
          "Type in the characters for your guess and press enter.\n" +
          "Enter a guess:   ")
    val input = readLine()
    if (parser.isValid(input, rowSize)) {
      parser.parse(input)
    } else {
      println("Invalid input. Try again.")
      requestGuess(rowSize)
    }
  }
}
