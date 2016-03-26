

import scala.util.Random

class SecretCodeImpl(rowSize: Int) extends SecretCode {
  val secretCode = {
    val r = Random
    for(i <- 1 to rowSize) yield PegFactory.getPegWithInt(r.nextInt())
  }
  
  override def toString(): String = {
    var result = ""
    for (peg <- secretCode)
      result += peg
    result
  }
}