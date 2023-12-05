import java.security.SecureRandom;

public class Deck {
      private static final SecureRandom randomNumbers = new SecureRandom(); // randomizer
      private static final int NUMBER_OF_CARDS = 52; // deck length
      
      private Card[] deck = new Card[NUMBER_OF_CARDS];
      private int currentCard = 0;
      
      public Deck() { // constructor
         String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Joker", "Queen", "King"};
         String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
         
         for (int count = 0; count < deck.length; count++) { // make 1 card for each suit and face combo.
               deck[count] = new Card (faces[count % 13], suits[count/13]);
         }
      } // constructor end
      
      public void shuffle() { // shuffle method
         currentCard = 0;
            
         for(int first = 0; first < deck.length; first++ ) { // take a card 
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS); // take a random card
         Card temp = deck[first]; // switch cards
         deck[first] = deck[second];
         deck[second] = temp;
         }
      } // shuffle method end
       
      public Card dealCard() { // deal card method
         if (currentCard < deck.length) { 
            return deck[currentCard++]; 
         } else { // stop
            return null;
         } 
      } // deal card method end
}