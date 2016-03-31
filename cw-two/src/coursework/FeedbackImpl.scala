package coursework

/**
 * Implements the trait Feedback.
 */
case class FeedbackImpl() extends Feedback{
  def getFeedback(code: Seq[Peg], guess: Seq[Peg]): Seq[FeedbackPeg] = makePegs(code, guess)
  
  /**
   * Come the secret code to a guess and returns any applicable WhiteFeedbackPegs.
   * 
   * @param code the secret code represented as a sequences of Pegs.
   * @param guess the user's guess represented as a sequence of Pegs.
   * @return a sequence of WhiteFeedbackPegs.
   */
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
 
 /**
  * Compares a Peg from the secret with a Peg from the user's guess.
  * It is implicitly expected that both Peg's have the same position.
  * 
  * @param code the Peg from the Secret Code.
  * @param guess the Peg from the user's guess.
  * @return a BlackFeedbackPeg if equal, otherwise an Empty FeedbackPeg.
  */
 private def blackPeg(code: Peg, guess: Peg): FeedbackPeg = {
    if (code.toString().equals(guess.toString())) {
      Peg.getFeedbackPeg("Black")
    } else {
      Peg.getFeedbackPeg("Empty")
    }
  }
 
  /**
   * Compares a sequence of FeedbackPegs to the Sceret Code. Discards Pegs from the code
   * if there is a corresponding BlackFeedbackPeg and retains a peg from the code if there 
   * is a corresponsing EmptyFeedbackPeg.
   * 
   * @param blacks a sequence of Black and Empty FeedbackPegs.
   * @param code the Secret Code.
   * @return the remaining pegs in the Secret Code for which we did not find BlackFeedbackPegs.
   */
  private def getLeftovers(blacks: Seq[FeedbackPeg], code: Seq[Peg]): Seq[Peg] = {
    val seq = blacks.zip(code)
    val leftovers = for ((black, codePeg) <- seq; if (black.toString().equals("Empty"))) yield codePeg
    leftovers
  }
 
  /**
   * Compares the secret code to a guess and return any applicable FeedbackPegs.
   * 
   * @param secret the Secret Code represented as a sequence of Pegs.
   * @param guess the user's guess represented as a sequence of Pegs.
   * @return a sequence of applicable FeedbackPegs.
   */
  private def makePegs(secret: Seq[Peg], guess: Seq[Peg]): Seq[FeedbackPeg]={
    val seqs = secret.zip(guess)
    val blacks = for ((secret, guess) <- seqs) yield blackPeg(secret, guess)
    val leftoverCode = getLeftovers(blacks, secret)
    val leftoverGuesses = getLeftovers(blacks, guess)
    val whites = whitePegCreator(leftoverCode, leftoverGuesses)
    blacks.filter(_.toString().equals("Black")) ++ whites
  }  
  
}
