

import com.google.inject.AbstractModule;
 
class GameModule extends AbstractModule{
  protected def configure(): Unit = {
    bind(classOf[Game]) to classOf[GameImpl] 
    bind(classOf[Guess]) to classOf[GuessImpl]
    bind(classOf[GuessParser]) to classOf[GuessParserImpl]
    bind(classOf[SecretCode]) to classOf[SecretCodeImpl]
  }
}