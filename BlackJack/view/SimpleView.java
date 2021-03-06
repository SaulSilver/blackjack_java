package BlackJack.view;

        import BlackJack.controller.PlayGame;
        import BlackJack.model.Game;

        import java.util.Scanner;

public class SimpleView implements IView
{

    public void DisplayWelcomeMessage()
    {
        for(int i = 0; i < 50; i++) {System.out.print("\n");};
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public int GetInput()
    {
        try {
            return System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public InputValue CheckInput(int input)
    {
        if (input == 'p')
        {
            return InputValue.Play;
        }
        else if (input == 'h')
        {
            return InputValue.Hit;
        }
        else if (input == 's')
        {
            return InputValue.Stand;
        }
        else if (input == 'q')
        {
            return InputValue.Quit;
        }
        return InputValue.Nothing;
    }

    public int GetStrategy(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What mode do you want? Basic (1) or Soft17 (2):");
        int number = 0;
        try {
            number = scan.nextInt();
        } catch (java.util.InputMismatchException e) {
            scan.nextLine();
        }
        if(number == 1) {return 1;}
        else if(number == 2) {return 2;}
        else { return 0; }
    }

    public void DisplayCard(BlackJack.model.Card a_card)
    {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Has: ");
        for(BlackJack.model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Dealer Won!");
        }
        else
        {
            System.out.println("You Won!");
        }
    }

    public void pause(){
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}