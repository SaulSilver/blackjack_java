package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {

    Game g = new Game();
    IView v = new SimpleView();
    PlayGame ctrl = new PlayGame();

    g.RegisterSubscribers(ctrl);

    while (ctrl.Play(g, v));
  }
}