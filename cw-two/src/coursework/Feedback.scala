package coursework

/**
 * Provides a service for providing Mastermind feedback.
 */
trait Feedback {
  
  /**
   * Provides Mastermind Feedback.
   * 
   * @param code the game's Secret Code which is represented as a sequence of Pegs.
   * @param guess the user's guess represented as a sequence of Pegs.
   * @return feedback represented as a sequence of FeedbackPegs.
   */
  def getFeedback(code: Seq[Peg], guess: Seq[Peg]): Seq[FeedbackPeg]
}
