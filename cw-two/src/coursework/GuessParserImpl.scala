

class GuessParserImpl(guess: String, rowSize: Int) extends GuessParser {
  def isValid(): Boolean = {
    val characters = guess.toCharArray()
    if(characters.size != rowSize) {
      false
    } else {
      for(letter <- characters) {
        if (PegFactory.getPegWithLetter(letter.toString).isEmpty) {
          return false
        }
      }
      true
    }
  }
  
  def parse(): Seq[Peg] = {
    val characters = guess.toCharArray()
    for (letter <- characters) yield PegFactory.getPegWithLetter(letter.toString).get
  }
}