public class Card {
   private final String face; // card info
   private final String suit;
   private final int value;
      
   public Card(String cardFace, String cardSuit) { // constructor
      this.face = cardFace;
      this.suit = cardSuit;
      int cardValue = 0;
      if (face.equals("Ace")) {
         cardValue = 1;
      } else if (face.equals("Two")) {
         cardValue = 2;
      } else if (face.equals("Three")) {
         cardValue = 3;
      } else if (face.equals("Four")) {
         cardValue = 4;
      } else if (face.equals("Five")) {
         cardValue = 5;
      } else if (face.equals("Six")) {
         cardValue = 6;
      } else if (face.equals("Seven")) {
         cardValue = 7;
      } else if (face.equals("Eight")) {
         cardValue = 8;
      } else if (face.equals("Nine")) {
         cardValue = 9;
      } else if (face.equals("Ten")) {
         cardValue = 10;
      } else if (face.equals("Joker")) {
         cardValue = 11;
      } else if (face.equals("Queen")) {
         cardValue = 12;
      } else if (face.equals("King")) {
         cardValue = 13;
      }
      this.value = cardValue;
   } // constructor end

   public String toString() { // string form
      return face + " of " + suit;
   }
   
   public int toInt() { // int form
      return value;
   }
}
         