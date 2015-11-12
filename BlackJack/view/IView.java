package BlackJack.view;

import BlackJack.model.rules.IHitStrategy;

public interface IView
{

  public enum InputValue{
    Play,
    Hit,
    Stand,
    Quit,
    Nothing
  }

  void DisplayWelcomeMessage();
  int GetInput();
  InputValue CheckInput(int input);
  int GetStrategy();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  void pause();
}