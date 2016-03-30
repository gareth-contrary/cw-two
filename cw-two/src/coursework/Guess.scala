package coursework

trait Guess {
  def requestGuess(rowSize: Int): Seq[Peg]
}