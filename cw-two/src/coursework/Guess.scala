package coursework
/**
 * Provides a service for requesting a guess from the user.
 */
trait Guess {
  /**
   * Requests a guess from the user.
   * 
   * @param rowSize the number of pegs in each guess.
   */
  def requestGuess(rowSize: Int): Seq[Peg]
}
