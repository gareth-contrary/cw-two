package coursework

/**
 * A parser for validating and transforming user input into a sequence of Pegs.
 */
trait GuessParser {
  
  /**
   * Validates user input.
   * 
   * @param guess the user input.
   * @param rowSize the number of Pegs being used in this Game.
   * @return whether the guess is valid.
   */
  def isValid(guess: String, rowSize: Int): Boolean
  
  /**
   * Transforms user input into a sequence of Pegs. Implicity expects input 
   * has been validated.
   * 
   * @param guess the user input.
   * @return a sequence of Pegs.
   */
  def parse(guess: String): Seq[Peg]
}
