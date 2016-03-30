package coursework

trait SecretCode {
  def generateCode(rowSize: Int): Seq[Peg]
}