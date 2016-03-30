package coursework

import com.google.inject.Guice;

object Factory {

  val injector = Guice.createInjector(new GameModule())
  
  def getInstance(c: Class[_], b: Boolean): Game = b match {
    case false => injector.getInstance(classOf[HardGame])
    case true => injector.getInstance(classOf[EasyGame])
  }
}