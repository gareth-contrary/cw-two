package coursework

import com.google.inject.Inject;

class EasyGame @Inject() (guess: Guess, feedback: Feedback, secretCode: SecretCode) extends HardGame(guess, feedback, secretCode) {
  override val showCode = true
}