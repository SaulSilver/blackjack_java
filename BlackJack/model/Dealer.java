package BlackJack.model;

import BlackJack.model.rules.*;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_soft17Rule;
  private DrawWinRule m_drawWinRule;
  private List<IObserver> m_observers;

  public Dealer(RulesFactory a_rulesFactory) {
    m_observers = new ArrayList<IObserver>();

    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_soft17Rule = a_rulesFactory.GetSoft17Rule();
    m_drawWinRule = a_rulesFactory.GetWinRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Stand(Player a_player)
  {

    boolean b = true;
    if (m_deck != null)
    {
      ShowHand();

      for (Card c : GetHand())
      {
        c.Show(true);
      }

      while (m_soft17Rule.DoHit(this))
      {
        b = m_soft17Rule.DoHit(this);
        GiveCard(m_deck, a_player, true);
      }
    }
    return b;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      GiveCard(m_deck, a_player, true);
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    if (a_player.CalcScore() > g_maxScore) {
      return true;
    } else if (CalcScore() > g_maxScore) {
      return false;
    }
    else if (CalcScore() == a_player.CalcScore())
    {
      m_drawWinRule.whoWins();
    }
    return CalcScore() >= a_player.CalcScore();
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_soft17Rule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public void GiveCard(Deck m_deck, Player a_player, boolean cardShown)
  {
    Card c = m_deck.GetCard();
    c.Show(cardShown);
    a_player.DealCard(c);

    for(IObserver observer : m_observers)
    {
      observer.updateHand(c);
    }
  }

  public void Register(IObserver a_subscriber)
  {
    m_observers.add(a_subscriber);
  }
}