package coursework

trait GuessParser {
  def isValid(guess: String, rowSize: Int): Boolean
  def parse(guess: String): Seq[Peg]
}