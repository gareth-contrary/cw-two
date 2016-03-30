package coursework

trait Feedback {
  def getFeedback(code: Seq[Peg], guess: Seq[Peg]): Seq[FeedbackPeg]
}