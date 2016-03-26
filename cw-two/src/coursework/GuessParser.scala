

trait GuessParser {
  def isValid(): Boolean
  def parse(): Seq[Peg]
}