package BlackJack.controller;

import BlackJack.model.Card;
import BlackJack.model.IObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;

import javax.swing.text.View;

public class PlayGame implements IObserver{

  private Game m_game;
  private IView m_view;

  public boolean Play(Game a_game, IView a_view) {
    m_game = a_game;
    m_view = a_view;

    m_view.DisplayWelcomeMessage();

    int strategyNumber = m_view.GetStrategy();


    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

    if (m_game.IsGameOver())
    {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    int input = m_view.GetInput();
    IView.InputValue inputValue = m_view.CheckInput(input);

    if(inputValue == IView.InputValue.Play)
    {
      m_game.NewGame();
    }
    else if (inputValue == IView.InputValue.Hit)
    {
      m_game.Hit();
    }
    else if (inputValue == IView.InputValue.Stand)
    {
      m_game.Stand();
    }
    return inputValue != IView.InputValue.Quit;
  }

  public void updateHand(Card card) {
    m_view.DisplayCard(card);
    m_view.pause();
  }

}