

  sealed trait Peg {
    val colour: String
    override def toString = colour
  }

  case class YellowPeg(colour: String = "Y") extends Peg
  case class RedPeg(colour: String = "R") extends Peg
  case class BluePeg(colour: String = "B") extends Peg
  case class GreenPeg(colour: String = "G") extends Peg
  case class OrangePeg(colour: String = "O") extends Peg
  case class PurplePeg(colour: String = "P") extends Peg
  
  sealed trait FeedbackPeg extends Peg
  case class WhiteFeedbackPeg(colour: String = "White") extends FeedbackPeg
  case class BlackFeedbackPeg(colour: String = "Black") extends FeedbackPeg
  case class EmptyFeedbackPeg(colour: String = "Empty") extends FeedbackPeg
  
  object PegFactory {
    def getPegWithInt(x: Int): Peg = math.abs(x) % 6 match {
      case 0 => YellowPeg()
      case 1 => RedPeg()
      case 2 => BluePeg()
      case 3 => GreenPeg()
      case 4 => OrangePeg()
      case 5 => PurplePeg()
    }
    
    def getPegWithLetter(letter: String): Option[Peg] = letter match {
      case "Y" => Some(YellowPeg())
      case "R" => Some(RedPeg())
      case "B" => Some(BluePeg())
      case "G" => Some(GreenPeg())
      case "O" => Some(OrangePeg())
      case "P" => Some(PurplePeg())
      case _ => None
    }
    
    def getFeedbackPeg(colour: String): FeedbackPeg = colour match {
      case "Black" => BlackFeedbackPeg()
      case "White" => WhiteFeedbackPeg()
      case "Empty" => EmptyFeedbackPeg()
    }
  }