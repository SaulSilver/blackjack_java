package BlackJack.controller;

import BlackJack.model.Card;
import BlackJack.model.IObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements IObserver{

  private Game m_game;
  private IView m_view;

  public boolean Play(Game a_game, IView a_view) {
    m_game = a_game;
    m_view = a_view;

    m_view.DisplayWelcomeMessage();

    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

    if (m_game.IsGameOver())
    {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    int input = m_view.GetInput();

    return m_view.CheckInput(m_game, input);
  }

  public boolean StartGame(Game a_game)
  {
    return a_game.NewGame();
  }

  public boolean HitOnce(Game a_game)
  {
    return a_game.Hit();
  }

  public boolean StandDown(Game a_game)
  {
    return a_game.Stand();
  }

  public void updateHand(Card card) {
    try {
      m_view.DisplayCard(card);
      Thread.sleep(999);
    }
    catch (InterruptedException e){ Thread.currentThread().interrupt(); }
  }

}