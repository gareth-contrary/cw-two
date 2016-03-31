package coursework

import com.google.inject.Inject;

/**
 * A version of Mastermind which does not display the Secret Code.
 * 
 * @param guess the service to request guesses from a user. Injected by Google Guice, @see GameModule.
 * @param feedback the service to produce Mastermind feedback. Injected by Google Guice, @see GameModule.
 * @param secretCode the service to produce a secret Mastermind code. Injected by Google Guice, @see GameModule.
 */
class HardGame @Inject() (guess: Guess, feedback: Feedback, secretCode: SecretCode) extends GameAbstractImpl() {
  //the number of Pegs used in this Game.
  val rowSize = 4
  val code = secretCode.generateCode(rowSize)
  val nrOfGuesses = 12
  val showCode = false
  
  override def runGames = {
    println("Welcome to Mastermind.\n" +
            "This is a text version of the classic board game Mastermind.\n" + 
            "The computer will think of a secret code.\n" + 
            "The code consists of 4 colored pegs.\n" + 
            "The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.\n" + 
            "A color may appear more than once in the code.\n" + 
            "\n" + 
            "You try to guess what colored pegs are in the code and what order they are in.\n" + 
            "After making a guess the result will be displayed." + 
            "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
            "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" + 
            "\n" +
            "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
            "When entering guesses you only need to enter the first character of the color as a capital letter.\n" +
            "\n" +
            "You have 12 to guess the answer or you lose the game.\n" +
            "\n" +
            "Generating secret code ....")
    if (showCode) {
      if (showCode){ 
       print("Secret Code is ")
       code.foreach(print)
       println("\n")
     }
    }
    
    var done = false
    var count = nrOfGuesses
    while(!done && count > 0){
      done = makeGuess()
      count -= 1
      println("You have " + count + " guesses left.\n")
      
    }  
  }
  
   /**
    * Requests a guess from the user.
    * 
    * @return true if the guess was correct.
    */
   private def makeGuess(): Boolean = {
     val newGuess =  guess.requestGuess(rowSize)
     val newFeedback = feedback.getFeedback(code, newGuess)
     val result = newFeedback mkString " "
     println(result)
     if (showCode){ 
       print("Secret Code is ")
       code.foreach(print)
       println("\n")
     }
     if (result.equals("Black Black Black Black")) {
       println("You have won! Congratulations!")
       true
     }else{
       false
     }
   }
}
