package BlackJack.view;

import BlackJack.controller.PlayGame;
import BlackJack.model.Game;

import java.util.Scanner;

public class SwedishView implements IView
    {
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack V�rlden");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' f�r att Spela, 'h' f�r nytt kort, 's' f�r att stanna 'q' f�r att avsluta\n");
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

        public int GetStrategy() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Vilket mode vill du ha? Basic (1) eller Soft17 (2):");
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
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hj�rter", "Spader", "Ruter", "Kl�ver" };
                String values[] =  
                    { "tv�", "tre", "fyra", "fem", "sex", "sju", "�tta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        public void pause(){
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Po�ng: " + a_score);
            System.out.println("");
        }
    }