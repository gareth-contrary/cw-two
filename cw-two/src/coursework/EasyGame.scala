package coursework

import com.google.inject.Inject;

/**
 * A version of Mastermind which displays the Secret Code.
 * Inherits the functionality of HardGame.
 * 
 * @param guess the service to request guesses from a user. Injected by Google Guice, @see GameModule.
 * @param feedback the service to produce Mastermind feedback. Injected by Google Guice, @see GameModule.
 * @param secretCode the service to produce a secret Mastermind code. Injected by Google Guice, @see GameModule.
 */
class EasyGame @Inject() (guess: Guess, feedback: Feedback, secretCode: SecretCode) extends HardGame(guess, feedback, secretCode) {
  override val showCode = true
}
