package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_soft17Rule;
  private IDrawWinRule m_drawWinRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
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

  public boolean Stand()
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
        GiveCard(m_deck, true);
      }
    }
    return b;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      GiveCard(m_deck, true);
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
}