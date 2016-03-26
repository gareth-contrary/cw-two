import com.google.inject.Guice;

object Factory {

  val injector = Guice.createInjector(new GameModule())
  
  def getInstance(c: Class[_], b: Boolean): Game = {
    injector.getInstance(classOf[GameImpl])
  }
}