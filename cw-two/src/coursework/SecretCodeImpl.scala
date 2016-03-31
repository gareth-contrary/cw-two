package coursework

import scala.util.Random

/**
 * Implements the trait SecretCode.
 */
class SecretCodeImpl() extends SecretCode {
  def generateCode(rowSize: Int): Seq[Peg] = {
    val r = Random
    for(i <- 1 to rowSize) yield Peg.getPegWithInt(r.nextInt())
  }
}
