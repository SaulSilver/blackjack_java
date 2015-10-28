package BlackJack.view;

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
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  void pause();
}