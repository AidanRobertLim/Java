// Aidan Lim
// Lab 2x2: Card Shuffling

import java.util.*;

public class BlackJack {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      boolean bool = true;
      String response;

      System.out.println("BLACK JACK");
      System.out.println("Would you like to play (yes or no)?"); // play 
      response = input.next();
     
      while (bool) {
          while (!response.equals("yes") && !response.equals("no")) { // invalid
               System.out.println("Sorry I didn't quite catch that.");
               response = input.next();
          } 
          if (response.equals("no")) { // no
               bool = !bool;
               break;
          }
          playGame(input); // yes
          System.out.println("Would you like to play again (yes or no)?"); // replay
          response = input.next();
      }      
      
      input.close();
   }

   public static void playGame(Scanner input) { // game method
      Deck myDeck = new Deck(); // initialize deck
      myDeck.shuffle();

      boolean bool = true;
      String response;
      int myPoints = 0;
      int theirPoints = 0;

      Card myCard = myDeck.dealCard(); // deal cards
      Card theirCard = myDeck.dealCard();
      myPoints = myPoints + myCard.toInt(); // determine points
      theirPoints = theirPoints + theirCard.toInt();

      System.out.println(); 
      System.out.println("YOUR INITAL CARD AND SCORE");
      System.out.println(myCard);
      System.out.println(myPoints + " points");
      System.out.println();
      System.out.println("THEIR INITIAL CARD AND SCORE");
      System.out.println(theirCard);
      System.out.println(theirPoints + " points");
      System.out.println();

      while (bool)  { 
         System.out.println("hit or stand?"); // hit or stand
         response = input.next();
         switch(response) {
            case "hit": // hit
               myCard = myDeck.dealCard(); // deal cards
               theirCard = myDeck.dealCard();
               myPoints = myPoints + myCard.toInt(); // determine points
               theirPoints = theirPoints + theirCard.toInt();

               System.out.println(); 
               System.out.println("YOUR CURRENT CARD AND SCORE");
               System.out.println(myCard);
               System.out.println(myPoints + " points");
               System.out.println();
               if (myPoints > 21 || theirPoints > 21) { // bust
                  bool = !bool;
               }
               break;
            case "stand": // stand
               theirCard = myDeck.dealCard(); // deal their card
               theirPoints = theirPoints + theirCard.toInt(); // determine their points
               bool = !bool;
               break;
            default: // invalid
               System.out.println("Sorry, I didn't quite catch that.");
               break;
         }
      }

      System.out.println(); // final hands
      System.out.println("YOUR FINAL CARD AND SCORE"); 
      System.out.println(myCard);
      System.out.println(myPoints + " points");
      System.out.println();
      System.out.println("THEIR FINAL CARD AND SCORE"); 
      System.out.println(theirCard);
      System.out.println(theirPoints + " points");
      System.out.println();

      if (myPoints > 21 && theirPoints <= 21) { // you bust
         System.out.println("You lose...");
      } else if (myPoints <= 21 && theirPoints > 21) { // they bust
         System.out.println("You win!");
      } else if (myPoints <= 21 && theirPoints <= 21) {
         if (myPoints < theirPoints) { // they compare
            System.out.println("You lose...");
         } else if (myPoints > theirPoints) { // you compare
            System.out.println("You win!");
         }
      } else { // both bust or both compare
         System.out.println("Tie!");
      }
   } // game method end
}