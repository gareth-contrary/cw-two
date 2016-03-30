package coursework

case class FeedbackImpl() extends Feedback{
  def getFeedback(code: Seq[Peg], guess: Seq[Peg]): Seq[FeedbackPeg] = makePegs(code, guess)
  
  private def whitePegCreator(code:Seq[Peg],guess:Seq[Peg]):Seq[FeedbackPeg]={
    var result:Seq[FeedbackPeg] = Nil
      for(p <- code){
        var found:Boolean = false
        for(g <- guess){
          if(p.colour.equals(g.colour) && !found){
            if(code.indexOf(p) != guess.indexOf(g)){             
              result = result :+ Peg.getFeedbackPeg("White")
              found =true
            }
          }
        }
      }
    result
  }
 
 private def blackPeg(code: Peg, guess: Peg): FeedbackPeg = {
    if (code.toString().equals(guess.toString())) {
      Peg.getFeedbackPeg("Black")
    } else {
      Peg.getFeedbackPeg("Empty")
    }
  }
 
  private def getLeftovers(blacks: Seq[FeedbackPeg], code: Seq[Peg]): Seq[Peg] = {
    val seq = blacks.zip(code)
    val leftovers = for ((black, codePeg) <- seq; if (black.toString().equals("Empty"))) yield codePeg
    leftovers
  }
 
  private def makePegs(secret:Seq[Peg],guess:Seq[Peg]):Seq[FeedbackPeg]={
    val seqs = secret.zip(guess)
    val blacks = for ((secret, guess) <- seqs) yield blackPeg(secret, guess)
    val leftoverCode = getLeftovers(blacks, secret)
    val leftoverGuesses = getLeftovers(blacks, guess)
    val whites = whitePegCreator(leftoverCode, leftoverGuesses)
    blacks.filter(_.toString().equals("Black")) ++ whites
  }  
  
}