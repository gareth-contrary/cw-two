package coursework

/**
 * A servie for generating Matermind's secret code.
 */
trait SecretCode {
  
  /**
   * Generate a random sequence of Pegs.
   * 
   * @param rowSize the number od Pegs used in this game.
   */
  def generateCode(rowSize: Int): Seq[Peg]
}
