package coursework

import com.google.inject.Inject;

class GuessParserImpl() extends GuessParser {
  def isValid(guess: String, rowSize: Int): Boolean = {
    val characters = guess.toCharArray()
    if(characters.size != rowSize) {
      false
    } else {
      for(letter <- characters) {
        if (Peg.getPegWithLetter(letter.toString).isEmpty) {
          false
        }
      }
      true
    }
  }
  
  def parse(guess: String): Seq[Peg] = {
    val characters = guess.toCharArray()
    for (letter <- characters) yield Peg.getPegWithLetter(letter.toString).get
  }
}