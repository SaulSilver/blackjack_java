package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;

    a_player.GiveCard(a_deck, true);

    a_dealer.GiveCard(a_deck, true);

    a_player.GiveCard(a_deck, true);

    a_dealer.GiveCard(a_deck, false);

    return true;
  }
}