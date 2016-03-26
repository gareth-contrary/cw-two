

object Factory {

  def getInstance(c: Class[_], b: Boolean): Game = {
    new GameImpl(b)   
  }
}