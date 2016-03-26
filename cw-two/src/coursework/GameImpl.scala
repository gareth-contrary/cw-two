

class GameImpl(showCode:Boolean) extends GameAbstractImpl {
  
  override def runGames = {
    val rowSize = 4
    val code = new SecretCodeImpl(rowSize)
    if(showCode){
       println("Secret code: " + code)
    }
   
    def makeGuess(): Boolean = {
      val result =  new FeedbackImpl(code, new GuessImpl(rowSize)).toString()
      println(result)
       if (result.equals("Black Black Black Black ")) {
         println("You have won! Congratulations!")
           true
        }else{
           false
         }
 
      }
    
  var done = false
  var count = 0
  while(!done && count < 12){
    done = makeGuess()
    count +=1
    }
  
  }
}